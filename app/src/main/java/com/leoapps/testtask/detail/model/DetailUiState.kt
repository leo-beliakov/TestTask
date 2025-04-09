package com.leoapps.testtask.detail.model

import androidx.annotation.DrawableRes

data class DetailUiState(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val quantity: Int,
    val totalPrice: String,
    @DrawableRes val imageRes: Int,
)