package com.leoapps.testtask.common.domain.repository

import com.leoapps.testtask.common.domain.model.MenuItem
import com.leoapps.testtask.common.domain.model.Restaurant

interface RestaurantRepository {
    fun getRestaurant(): Restaurant
    fun getMenuItemById(id: Int): MenuItem?
}