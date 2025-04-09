package com.leoapps.testtask.main.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.main.presentation.model.Offer
import com.leoapps.testtask.theme.theme.appRed
import com.leoapps.testtask.theme.theme.appYellow
import com.leoapps.testtask.theme.theme.primaryText
import com.leoapps.testtask.theme.theme.secondaryText

@Composable
fun SpecialOfferItem(
    offer: Offer,
    itemWidth: Dp
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.width(itemWidth)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(id = offer.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
            )
            Text(
                text = offer.discount,
                fontWeight = FontWeight.Bold,
                color = primaryText,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
                    .background(appYellow, RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
            AddButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
            )
        }
        // Price + discount
        Text(
            text = offer.currentPrice,
            color = appRed,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = offer.oldPrice,
            color = secondaryText,
            textDecoration = TextDecoration.LineThrough,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = offer.title,
            color = primaryText,
            style = MaterialTheme.typography.bodySmall
        )
    }
}