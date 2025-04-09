package com.leoapps.testtask.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun QuantitySelector(
    quantity: Int,
    onQuantityChanged: (Int) -> Unit,
    modifier: Modifier
) {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(100.dp),
        shadowElevation = 2.dp,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(8.dp)
        ) {
            IconButton(
                onClick = { if (quantity > 1) onQuantityChanged(quantity - 1) },
                modifier = Modifier.size(32.dp)
            ) {
                Text(
                    text = "−",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                // ensures that the text doesn't jump when the quantity changes.
                // although, it's a dirty hack, because it's bad for accessibility.
                Text(
                    text = "000",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Transparent,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = quantity.toString(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            IconButton(
                onClick = { onQuantityChanged(quantity + 1) },
                modifier = Modifier.size(32.dp)
            ) {
                Text(
                    text = "+",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}