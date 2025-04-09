package com.leoapps.testtask.main.presentation

import androidx.lifecycle.ViewModel
import com.leoapps.testtask.common.domain.repository.RestaurantRepository
import com.leoapps.testtask.main.presentation.model.CategoryTab
import com.leoapps.testtask.main.presentation.model.RestaurantUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RestaurantViewModel(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RestaurantUiState())
    val uiState: StateFlow<RestaurantUiState> = _uiState.asStateFlow()

    init {
        loadRestaurantData()
    }

    private fun loadRestaurantData() {
        val restaurant = repository.getRestaurant()
        val categoriesTabs = buildList {
            add(
                CategoryTab(
                    id = 0,
                    title = "Специальные предложения",
                )
            )
            addAll(
                restaurant.categories.map { category ->
                    CategoryTab(
                        id = category.id,
                        title = category.title,
                    )
                }
            )
        }
        _uiState.value = RestaurantUiState(
            restaurantName = restaurant.name,
            rating = restaurant.rating,
            schedule = restaurant.schedule,
            deliveryTime = restaurant.deliveryTime,
            categories = restaurant.categories,
            specialOffers = restaurant.specialOffers,
            categoriesTabs = categoriesTabs
        )
    }
}