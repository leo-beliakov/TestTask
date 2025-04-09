package com.leoapps.testtask.main.presentation

import androidx.lifecycle.ViewModel
import com.leoapps.testtask.R
import com.leoapps.testtask.main.presentation.model.Category
import com.leoapps.testtask.main.presentation.model.CategoryTab
import com.leoapps.testtask.main.presentation.model.MenuItem
import com.leoapps.testtask.main.presentation.model.Offer
import com.leoapps.testtask.main.presentation.model.RestaurantUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RestaurantViewModel : ViewModel() {

    private val categories = listOf(
        Category(
            id = 1,
            title = "Азиатская кухня",
            items = listOf(
                MenuItem(
                    title = "Креветки",
                    description = "Подается с луком, свежими овощами — отличный выбор...",
                    price = "28,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Креветки 2 ",
                    description = "Подается с луком, свежими овощами — отличный выбор...",
                    price = "28,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Креветки 3",
                    description = "Подается с луком, свежими овощами — отличный выбор...",
                    price = "28,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Креветки",
                    description = "Подается с луком, свежими овощами — отличный выбор...",
                    price = "10,000 сум",
                    imageRes = R.drawable.img_padthai
                )
            )
        ),
        Category(
            id = 2,
            title = "Закуски",
            items = listOf(
                MenuItem(
                    title = "Кальмары",
                    description = "Кольца кальмара в панировке...",
                    price = "18,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Кальмары2",
                    description = "Кольца кальмара в панировке...",
                    price = "18,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Кальмары3",
                    description = "Кольца кальмара в панировке...",
                    price = "18,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Спринг-роллы",
                    description = "Тонкие роллы с овощами и мясом...",
                    price = "12,000 сум",
                    imageRes = R.drawable.img_padthai
                )
            )
        ),
        Category(
            id = 3,
            title = "Напитки",
            items = listOf(
                MenuItem(
                    title = "Мохито",
                    description = "Освежающий напиток с мятой и лаймом...",
                    price = "15,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Мохито1",
                    description = "Освежающий напиток с мятой и лаймом...",
                    price = "15,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Мохито2",
                    description = "Освежающий напиток с мятой и лаймом...",
                    price = "15,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Мохито4",
                    description = "Освежающий напиток с мятой и лаймом...",
                    price = "15,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Мохито5",
                    description = "Освежающий напиток с мятой и лаймом...",
                    price = "15,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
                MenuItem(
                    title = "Мохито6",
                    description = "Освежающий напиток с мятой и лаймом...",
                    price = "15,000 сум",
                    imageRes = R.drawable.img_padthai
                ),
            ),
        ),
    )

    private val _uiState = MutableStateFlow(
        RestaurantUiState(
            rating = 4.7,
            schedule = "11:00 – 23:00",
            deliveryTime = "15–20",
            specialOffers = listOf(
                Offer(
                    title = "Куриные шашлычки",
                    currentPrice = "65 000 сум",
                    oldPrice = "78 000 сум",
                    discount = "-20%",
                    imageRes = R.drawable.img_scewers
                ),
                Offer(
                    title = "Панкейки",
                    currentPrice = "45 000 сум",
                    oldPrice = "54 000 сум",
                    discount = "-20%",
                    imageRes = R.drawable.img_puncace
                ),
                Offer(
                    title = "Шурпа",
                    currentPrice = "50 000 сум",
                    oldPrice = "60 000 сум",
                    discount = "-20%",
                    imageRes = R.drawable.img_shurpa
                )
            ),
            categories = categories,
            restaurantName = "F&b chef",
            categoriesTabs = buildList {
                add(
                    CategoryTab(
                        id = 0,
                        title = "Cпециальные предложения",
                    )
                )
                addAll(
                    categories.map { category ->
                        CategoryTab(
                            id = category.id,
                            title = category.title,
                        )
                    }
                )
            }
        )
    )
    val uiState: StateFlow<RestaurantUiState> = _uiState
}