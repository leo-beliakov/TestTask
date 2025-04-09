package com.leoapps.testtask.main.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.common.theme.theme.primaryText
import com.leoapps.testtask.main.presentation.model.CategoryTab

@Composable
fun CategoryTabs(
    categories: List<CategoryTab>,
    selectedCategoryId: Int,
    onTabSelected: (Int) -> Unit
) {
    val selectedTabIndex = remember(categories, selectedCategoryId) {
        categories.indexOfFirst { it.id == selectedCategoryId }
    }

    ScrollableTabRow(
        selectedTabIndex = categories.indexOfFirst { it.id == selectedCategoryId },
        containerColor = Color.White,
        contentColor = Color.Black,
        edgePadding = 16.dp,
        modifier = Modifier.fillMaxWidth(),
        divider = {},
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                color = primaryText,
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
            )
        },
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = category.id == selectedCategoryId,
                onClick = { onTabSelected(category.id) },
                text = {
                    Text(category.title)
                }
            )
        }
    }
}