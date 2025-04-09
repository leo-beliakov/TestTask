package com.leoapps.testtask.main.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.R
import com.leoapps.testtask.common.theme.theme.primaryText

@Composable
fun HeaderToolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconedButton(
            painter = painterResource(R.drawable.ic_right_arrow),
            background = Color.White,
            tint = primaryText,
            onClick = { /* back */ },
            modifier = Modifier.rotate(180f), // dirty hack to reuse the same icon as there's an issue with the arrow left icon (the UI team's fault)
        )
        Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
            IconedButton(
                painter = painterResource(R.drawable.ic_share),
                background = Color.White,
                tint = primaryText,
                onClick = { /* back */ },
            )
            IconedButton(
                painter = painterResource(R.drawable.ic_search),
                background = Color.White,
                tint = primaryText,
                onClick = { /* back */ },
            )
        }
    }
}