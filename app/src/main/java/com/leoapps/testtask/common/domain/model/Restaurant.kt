package com.leoapps.testtask.common.domain.model

data class Restaurant(
    val id: Int = 1,
    val name: String,
    val rating: Double,
    val schedule: String,
    val deliveryTime: String,
    val categories: List<Category>,
    val specialOffers: List<Offer>
) 