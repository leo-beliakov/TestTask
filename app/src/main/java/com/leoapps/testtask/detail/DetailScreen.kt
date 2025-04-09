package com.leoapps.testtask.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.R
import com.leoapps.testtask.common.theme.theme.appRed
import com.leoapps.testtask.common.theme.theme.placeholder
import com.leoapps.testtask.common.theme.theme.primaryText
import com.leoapps.testtask.common.theme.theme.secondaryText
import com.leoapps.testtask.detail.composables.QuantitySelector
import com.leoapps.testtask.main.presentation.composables.IconedButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    onDismiss: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    var comment by remember { mutableStateOf("") }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = placeholder,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                IconedButton(
                    onClick = onDismiss,
                    painter = painterResource(R.drawable.ic_close),
                    tint = primaryText,
                    background = Color.White,
                    modifier = Modifier.align(Alignment.TopEnd)
                )
                Image(
                    painter = painterResource(id = uiState.imageRes),
                    contentDescription = uiState.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "★",
                        color = appRed,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = "4.4",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Text(
                    text = uiState.title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = uiState.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = secondaryText,
                    overflow = TextOverflow.Visible,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Оставьте комментарий...",
                    style = MaterialTheme.typography.bodyMedium,
                    color = secondaryText,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    BasicTextField(
                        value = comment,
                        onValueChange = { comment = it },
                        textStyle = TextStyle(
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Bottom section with quantity and add button
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Quantity selector
                    QuantitySelector(
                        quantity = uiState.quantity,
                        onQuantityChanged = { viewModel.updateQuantity(it) }
                    )

                    // Add button with price
                    Button(
                        onClick = { onDismiss() },
                        colors = ButtonDefaults.buttonColors(containerColor = appRed),
                        modifier = Modifier.height(48.dp)
                    ) {
                        Text(
                            text = "Добавить ${uiState.totalPrice}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

