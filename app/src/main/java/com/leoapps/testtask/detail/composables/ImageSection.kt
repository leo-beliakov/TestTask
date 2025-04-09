package com.leoapps.testtask.detail.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.leoapps.testtask.R
import com.leoapps.testtask.common.theme.theme.primaryText
import com.leoapps.testtask.main.presentation.composables.IconedButton

@Composable
fun ImageSection(
    @DrawableRes imageRes: Int,
    onCloseClicked: () -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        IconedButton(
            onClick = onCloseClicked,
            painter = painterResource(R.drawable.ic_close),
            tint = primaryText,
            background = Color.White,
            size = 32.dp,
            padding = 10.dp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 20.dp)
        )

        val imagePainter = painterResource(imageRes).intrinsicSize
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 20.dp)
                .aspectRatio(imagePainter.width / (imagePainter.height * 0.7f))
                .fillMaxWidth()
        )
    }

}