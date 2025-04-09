package com.leoapps.testtask.detail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.R
import com.leoapps.testtask.common.theme.theme.appGreen
import com.leoapps.testtask.common.theme.theme.secondaryText

@Composable
fun DescriptionSection(
    title: String,
    description: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(0.dp, 0.dp, 12.dp, 12.dp))
            .padding(vertical = 22.dp, horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 8.dp)
            )
            Spacer(
                modifier = Modifier.weight(1f, true)
            )
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                tint = appGreen,
                modifier = Modifier.padding(end = 6.dp)
            )
            Text(
                text = "4.4",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = secondaryText,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}