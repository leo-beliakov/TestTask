package com.leoapps.testtask.main.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.main.presentation.model.CategoryTab

@Composable
fun TopBar(
    title: String,
    categories: List<CategoryTab>,
    selectedCategoryId: Int,
    onTabSelected: (Int) -> Unit,
    showTabs: Boolean,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = showTabs,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically(),
        modifier = modifier
    ) {
        TopBarContent(
            title = title,
            categories = categories,
            selectedCategoryId = selectedCategoryId,
            onTabSelected = onTabSelected
        )
    }
}

@Composable
fun TopBarContent(
    title: String,
    categories: List<CategoryTab>,
    selectedCategoryId: Int,
    onTabSelected: (Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shadowElevation = 12.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .statusBarsPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(
                    modifier = Modifier.size(ICONED_BUTTON_SIZE_DP.dp)
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .weight(1f, true)
                        .padding(horizontal = 12.dp)
                )
                Spacer(
                    modifier = Modifier.width(ICONED_BUTTON_SIZE_DP.dp * 2 + 30.dp)
                )
            }
            if (categories.isNotEmpty()) {
                CategoryTabs(
                    categories = categories,
                    selectedCategoryId = selectedCategoryId,
                    onTabSelected = onTabSelected
                )
            }
        }
    }
}