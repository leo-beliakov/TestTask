package com.leoapps.testtask.main.presentation.model

data class RestaurantUiState(
    val restaurantName: String,
    val rating: Double,
    val schedule: String,
    val deliveryTime: String,
    val specialOffers: List<Offer> = emptyList(),
    val categories: List<Category> = emptyList(),
    val categoriesTabs: List<CategoryTab> = emptyList(),
)