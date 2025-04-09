package com.leoapps.testtask.main.presentation.composables

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.common.theme.theme.placeholder
import com.leoapps.testtask.common.utils.shimmerEffect
import com.leoapps.testtask.main.presentation.CATEGORY_HEADER_PADDING_DP

@Composable
fun RestaurantScreenShimmer() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        DetailsRowShimmer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        SpecialOffersSectionShimmer()
        repeat(3) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(top = CATEGORY_HEADER_PADDING_DP.dp)
                    .padding(horizontal = 16.dp)
                    .height(22.dp)
                    .shimmerEffect()
            )
            repeat(3) {
                MenuItemShimmer()
            }
        }
    }
}

@Composable
fun DetailsRowShimmer(
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.height(40.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(16.dp)
                .padding(horizontal = 16.dp)
                .shimmerEffect(shape = RoundedCornerShape(4.dp))
        )
        VerticalDivider(
            modifier = Modifier.fillMaxHeight(),
            thickness = 2.dp,
            color = placeholder,
        )
        Box(
            modifier = Modifier
                .weight(2f)
                .height(16.dp)
                .padding(horizontal = 16.dp)
                .shimmerEffect(shape = RoundedCornerShape(4.dp))
        )
        VerticalDivider(
            modifier = Modifier.fillMaxHeight(),
            thickness = 1.dp,
            color = placeholder,
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(16.dp)
                .padding(horizontal = 16.dp)
                .shimmerEffect(shape = RoundedCornerShape(4.dp))
        )
    }
}

@Composable
fun SpecialOffersSectionShimmer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(7f)
                    .height(24.dp)
                    .shimmerEffect()
            )
            Spacer(
                modifier = Modifier.weight(2f)
            )
            Box(
                modifier = Modifier
                    .weight(2f)
                    .height(18.dp)
                    .shimmerEffect()
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState(), false)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp)
        ) {
            repeat(3) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.width(SPECIAL_OFFER_ITEM_WIDTH_DP.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .shimmerEffect()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(top = 8.dp)
                            .height(16.dp)
                            .shimmerEffect()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(top = 4.dp)
                            .height(14.dp)
                            .shimmerEffect()
                    )
                }
            }
        }
    }
}

@Composable
fun MenuItemShimmer() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(22.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .weight(5f)
                .height(64.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(16.dp)
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 8.dp)
                    .height(16.dp)
                    .shimmerEffect()
            )
        }
        Box(
            modifier = Modifier
                .weight(2f)
                .height(64.dp)
                .shimmerEffect()
        )
    }
} 