package com.leoapps.testtask.main.presentation.model

import com.leoapps.testtask.common.domain.model.Category
import com.leoapps.testtask.common.domain.model.Offer

data class RestaurantUiState(
    val restaurantName: String = "",
    val rating: Double = 0.0,
    val schedule: String = "",
    val deliveryTime: String = "",
    val categories: List<Category> = emptyList(),
    val specialOffers: List<Offer> = emptyList(),
    val categoriesTabs: List<CategoryTab> = emptyList()
)