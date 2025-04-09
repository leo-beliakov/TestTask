package com.leoapps.testtask.common.domain.model

data class Offer(
    val id: Int = 0,
    val title: String,
    val currentPrice: String,
    val oldPrice: String,
    val discount: String,
    val imageRes: Int
)