package com.leoapps.testtask.main.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.common.domain.model.Category
import com.leoapps.testtask.common.utils.dpToPx
import com.leoapps.testtask.main.presentation.composables.CategoryHeader
import com.leoapps.testtask.main.presentation.composables.DetailsRow
import com.leoapps.testtask.main.presentation.composables.HeaderToolbar
import com.leoapps.testtask.main.presentation.composables.MenuItemRow
import com.leoapps.testtask.main.presentation.composables.RestaurantHeader
import com.leoapps.testtask.main.presentation.composables.RestaurantScreenShimmer
import com.leoapps.testtask.main.presentation.composables.SpecialOffersSection
import com.leoapps.testtask.main.presentation.composables.TopBar
import com.leoapps.testtask.main.presentation.model.RestaurantUiState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

const val CATEGORY_HEADER_PADDING_DP = 45
const val STATIC_ELEMENTS_COUNT = 3

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun RestaurantScreen(
    viewModel: RestaurantViewModel = koinViewModel<RestaurantViewModel>(),
    onItemClick: (Int) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var topBarHeight by remember { mutableIntStateOf(0) }

    val showTabs by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex != 0 || listState.firstVisibleItemScrollOffset > 100f
        }
    }

    // Track the currently selected category tab
    var selectedCategoryId by remember {
        mutableIntStateOf(
            uiState.categories.firstOrNull()?.id ?: 0
        )
    }
    val extraScrollPerCategory = dpToPx(CATEGORY_HEADER_PADDING_DP.dp).toInt() / 2

    Box(modifier = Modifier.fillMaxSize()) {
        RestaurantScreenContent(
            topBarHeight = topBarHeight,
            extraScrollPerCategory = extraScrollPerCategory,
            uiState = uiState,
            listState = listState,
            onScrollToCategory = { selectedCategoryId = it },
            onItemClick = onItemClick
        )

        TopBar(
            title = uiState.restaurantName,
            categories = uiState.categoriesTabs,
            showTabs = showTabs,
            selectedCategoryId = selectedCategoryId,
            onTabSelected = { catId ->
                coroutineScope.launch {
                    val (index, offset) = calculateScrollPosition(
                        topBarHeight = topBarHeight,
                        extraScrollPerCategory = extraScrollPerCategory,
                        categories = uiState.categories,
                        selectedCategoryId = catId
                    )
                    listState.animateScrollToItem(
                        index = index,
                        scrollOffset = offset,
                    )
                    selectedCategoryId = catId
                }
            },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .onGloballyPositioned { topBarHeight = it.size.height },
        )
        HeaderToolbar(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 16.dp)
                .statusBarsPadding()
        )
    }
}

@Composable
fun RestaurantScreenContent(
    uiState: RestaurantUiState,
    listState: LazyListState,
    onScrollToCategory: (Int) -> Unit,
    onItemClick: (Int) -> Unit,
    topBarHeight: Int,
    extraScrollPerCategory: Int,
) {
    // Observing scrolling to update the tab selection
    LaunchedEffect(listState, topBarHeight) {
        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .collect { (index, offset) ->
                val indexToScroll = calculateTabForCategory(
                    index = index,
                    offset = offset,
                    topBarHeight = topBarHeight,
                    extraScrollPerCategory = extraScrollPerCategory,
                    categories = uiState.categories
                )
                println("MyTag: indexToScroll = $indexToScroll, fwi = $index, offset = $offset, topBarHeight = $topBarHeight extraScrollPerCategory = $extraScrollPerCategory")
                onScrollToCategory(indexToScroll)
            }
    }

    LazyColumn(
        userScrollEnabled = !uiState.isLoading,
        state = listState,
        contentPadding = PaddingValues(
            bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
        ),
    ) {
        item {
            RestaurantHeader(
                restaurantName = uiState.restaurantName,
            )
        }
        if (uiState.isLoading) {
            item {
                RestaurantScreenShimmer()
            }
        } else {
            item {
                DetailsRow(
                    rating = uiState.rating,
                    schedule = uiState.schedule,
                    deliveryTime = uiState.deliveryTime,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
            item {
                SpecialOffersSection(
                    title = "Специальные предложения",
                    offers = uiState.specialOffers,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
            uiState.categories.forEachIndexed { index, category ->
                item {
                    CategoryHeader(
                        title = category.title,
                        modifier = Modifier.padding(top = CATEGORY_HEADER_PADDING_DP.dp)
                    )
                }
                items(category.items.size) { itemIndex ->
                    val menuItem = category.items[itemIndex]
                    MenuItemRow(
                        title = menuItem.title,
                        description = menuItem.description,
                        price = menuItem.price,
                        imageRes = menuItem.imageRes,
                        onClick = { onItemClick(menuItem.id) }
                    )
                }
            }
        }
    }
}

// This function contains some durty hacks because solution out of the box doesnt work
fun calculateTabForCategory(
    index: Int,
    offset: Int,
    topBarHeight: Int,
    extraScrollPerCategory: Int,
    categories: List<Category>
) = when {
    index in 0..1 -> 0
    index == 2 && offset < topBarHeight - extraScrollPerCategory * 2 -> 0
    index == 2 && offset >= topBarHeight - extraScrollPerCategory * 2 -> 1
    else -> {
        // some elements are covered by the top bar and not visible:
        val extraOffsetElements = 2
        var accIndex = STATIC_ELEMENTS_COUNT
        var result = 0

        for (category in categories) {
            // each category has a header and items:
            accIndex += 1 + category.items.size
            if (accIndex - extraOffsetElements > index) {
                result = category.id
                break
            }
        }

        result
    }
}

fun calculateScrollPosition(
    categories: List<Category>,
    selectedCategoryId: Int,
    topBarHeight: Int,
    extraScrollPerCategory: Int,
): Pair<Int, Int> {
    val categoryIndex = categories.indexOfFirst { it.id == selectedCategoryId }
    if (categoryIndex == -1) return STATIC_ELEMENTS_COUNT - 1 to -topBarHeight

    val precedingCategories = categories.take(categoryIndex)
    val targetIndex = STATIC_ELEMENTS_COUNT + precedingCategories.sumOf { it.items.size + 1 }
    return targetIndex to -topBarHeight + extraScrollPerCategory
}


