package com.leoapps.testtask.common.data.repository

import com.leoapps.testtask.R
import com.leoapps.testtask.common.domain.model.Category
import com.leoapps.testtask.common.domain.model.MenuItem
import com.leoapps.testtask.common.domain.model.Offer
import com.leoapps.testtask.common.domain.model.Restaurant
import com.leoapps.testtask.common.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl : RestaurantRepository {

    private val menuItems = listOf(
        MenuItem(
            id = 101,
            title = "Креветки",
            description = "Креветки в сливочном соусе с чесноком. Нежные тигровые креветки, обжаренные до золотистой корочки, подаются в ароматном сливочно-чесночном соусе с легкими травами.",
            price = "65 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 102,
            title = "Креветки 2",
            description = "Подается с луком, свежими овощами — отличный выбор...",
            price = "28 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 103,
            title = "Креветки 3",
            description = "Подается с луком, свежими овощами — отличный выбор...",
            price = "28 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 104,
            title = "Том Ям",
            description = "Подается с луком, свежими овощами — отличный выбор...",
            price = "42 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 201,
            title = "Кальмары",
            description = "Кольца кальмара в панировке...",
            price = "18 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 202,
            title = "Кальмары2",
            description = "Кольца кальмара в панировке...",
            price = "18 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 203,
            title = "Кальмары3",
            description = "Кольца кальмара в панировке...",
            price = "18 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 204,
            title = "Спринг-роллы",
            description = "Тонкие роллы с овощами и мясом...",
            price = "12 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 301,
            title = "Мохито",
            description = "Освежающий напиток с мятой и лаймом...",
            price = "15 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 302,
            title = "Мохито1",
            description = "Освежающий напиток с мятой и лаймом...",
            price = "15 000 сум",
            imageRes = R.drawable.img_padthai
        ),
        MenuItem(
            id = 303,
            title = "Мохито2",
            description = "Освежающий напиток с мятой и лаймом...",
            price = "15 000 сум",
            imageRes = R.drawable.img_padthai
        )
    )

    private val categories = listOf(
        Category(
            id = 1,
            title = "Азиатская кухня",
            items = menuItems.filter { it.id in 101..199 }
        ),
        Category(
            id = 2,
            title = "Закуски",
            items = menuItems.filter { it.id in 200..299 }
        ),
        Category(
            id = 3,
            title = "Напитки",
            items = menuItems.filter { it.id in 300..399 }
        )
    )

    private val specialOffers = listOf(
        Offer(
            id = 1,
            title = "Куриные шашлычки",
            currentPrice = "65 000 сум",
            oldPrice = "78 000 сум",
            discount = "-20%",
            imageRes = R.drawable.img_scewers
        ),
        Offer(
            id = 2,
            title = "Панкейки",
            currentPrice = "45 000 сум",
            oldPrice = "54 000 сум",
            discount = "-20%",
            imageRes = R.drawable.img_puncace
        ),
        Offer(
            id = 3,
            title = "Шурпа",
            currentPrice = "50 000 сум",
            oldPrice = "60 000 сум",
            discount = "-20%",
            imageRes = R.drawable.img_shurpa
        )
    )

    private val restaurant = Restaurant(
        id = 1,
        name = "F&b chef",
        rating = 4.7,
        schedule = "11:00 – 23:00",
        deliveryTime = "15–20",
        categories = categories,
        specialOffers = specialOffers
    )

    override fun getRestaurant(): Restaurant = restaurant

    override fun getMenuItemById(id: Int): MenuItem? {
        return menuItems.find { it.id == id }
    }
}