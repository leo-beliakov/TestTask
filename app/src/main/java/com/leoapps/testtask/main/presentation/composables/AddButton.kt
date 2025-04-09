package com.leoapps.testtask.main.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.R
import com.leoapps.testtask.common.theme.theme.placeholder
import com.leoapps.testtask.common.theme.theme.primaryText

@Composable
fun AddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconedButton(
        painter = painterResource(R.drawable.ic_add),
        onClick = onClick,
        background = placeholder,
        tint = primaryText,
        size = 42.dp,
        padding = 14.dp,
        modifier = modifier,
    )
}

