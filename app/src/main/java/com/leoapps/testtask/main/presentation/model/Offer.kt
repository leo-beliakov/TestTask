package com.leoapps.testtask.main.presentation.model

import androidx.annotation.DrawableRes

data class Offer(
    val title: String,
    val currentPrice: String,
    val oldPrice: String,
    val discount: String,
    @DrawableRes val imageRes: Int,
)