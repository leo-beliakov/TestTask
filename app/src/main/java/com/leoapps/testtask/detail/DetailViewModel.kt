package com.leoapps.testtask.detail

import androidx.lifecycle.ViewModel
import com.leoapps.testtask.common.domain.repository.RestaurantRepository
import com.leoapps.testtask.detail.model.DetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailViewModel(
    private val initialItemId: Int,
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(getInitailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private fun getInitailUiState(): DetailUiState {
        val menuItem = repository.getMenuItemById(initialItemId)
            ?: throw IllegalArgumentException("Menu item with id $initialItemId not found")

        return DetailUiState(
            id = menuItem.id,
            title = menuItem.title,
            description = menuItem.description,
            price = menuItem.price,
            imageRes = menuItem.imageRes,
            quantity = 1,
            totalPrice = menuItem.price
        )
    }

    fun updateQuantity(newQuantity: Int) {
        _uiState.update { currentState ->
            val basePrice = extractBasePrice(currentState.price)
            val total = newQuantity * basePrice

            currentState.copy(
                quantity = newQuantity,
                totalPrice = formatPrice(total)
            )
        }
    }

    private fun extractBasePrice(priceString: String): Int {
        val digits = priceString.filter { it.isDigit() }
        return if (digits.isNotEmpty()) digits.toInt() else 0
    }

    private fun formatPrice(amount: Int): String {
        return "${amount.toString().chunked(3).joinToString(" ")} сум"
    }
} 