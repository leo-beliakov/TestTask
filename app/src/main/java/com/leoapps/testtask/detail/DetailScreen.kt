package com.leoapps.testtask.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.common.theme.theme.appGreen
import com.leoapps.testtask.common.theme.theme.placeholder
import com.leoapps.testtask.common.theme.theme.primaryText
import com.leoapps.testtask.common.theme.theme.secondaryText
import com.leoapps.testtask.detail.composables.DescriptionSection
import com.leoapps.testtask.detail.composables.ImageSection
import com.leoapps.testtask.detail.composables.QuantitySelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    onDismiss: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = placeholder,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .imePadding()
        ) {
            ImageSection(
                imageRes = uiState.imageRes,
                onCloseClicked = onDismiss,
                modifier = Modifier.fillMaxWidth()
            )
            DescriptionSection(
                title = uiState.title,
                description = uiState.description,
                modifier = Modifier.fillMaxWidth()
            )
            FeedbackSection(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .background(Color.White)
                    .padding(horizontal = 16.dp)
                    .padding(top = 12.dp, bottom = 34.dp)
                    .navigationBarsPadding()
            ) {
                QuantitySelector(
                    quantity = uiState.quantity,
                    onQuantityChanged = { viewModel.updateQuantity(it) },
                    modifier = Modifier.fillMaxHeight()
                )
                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(containerColor = appGreen),
                    modifier = Modifier.weight(1f, true)
                ) {
                    Text(
                        text = "Добавить\n${uiState.totalPrice}",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}

@Composable
fun FeedbackSection(modifier: Modifier) {
    var comment by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(12.dp, 12.dp, 0.dp, 0.dp))
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)
    ) {
        PlainTextField(
            value = comment,
            onValueChange = { comment = it },
            placeholder = "Оставьте комментарий...",
        )
        HorizontalDivider(
            color = placeholder,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PlainTextField(
    value: String,
    minLines: Int = 3,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
) {
    val textStyle = MaterialTheme.typography.bodyLarge
    val minHeightDp = with(LocalDensity.current) { (textStyle.lineHeight * minLines).toDp() }

    BasicTextField(
        value = value,
        maxLines = 3,
        minLines = 3,
        onValueChange = onValueChange,
        modifier = modifier.heightIn(min = minHeightDp),
        textStyle = MaterialTheme.typography.bodyLarge.copy(color = primaryText),
        singleLine = true,
        decorationBox = { innerTextField ->
            if (value.isEmpty()) {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.bodyLarge.copy(color = secondaryText)
                )
            }
            innerTextField()
        }
    )
}
