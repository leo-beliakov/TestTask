package com.leoapps.testtask.main.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

const val ICONED_BUTTON_SIZE_DP = 36
const val ICONED_BUTTON_PADDING_DP = 8

@Composable
fun IconedButton(
    painter: Painter,
    background: Color = Color.LightGray,
    tint: Color = Color.Black,
    onClick: () -> Unit,
    size: Dp = ICONED_BUTTON_SIZE_DP.dp,
    padding: Dp = ICONED_BUTTON_PADDING_DP.dp,
    modifier: Modifier = Modifier,
) {
    Icon(
        painter = painter,
        contentDescription = "Add",
        tint = tint,
        modifier = modifier
            .size(size)
            .background(background, CircleShape)
            .clip(CircleShape)
            .clickable { onClick() }
            .padding(padding)
    )
}