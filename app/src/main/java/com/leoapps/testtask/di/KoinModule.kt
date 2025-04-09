package com.leoapps.testtask.di

import com.leoapps.testtask.common.data.repository.RestaurantRepositoryImpl
import com.leoapps.testtask.common.domain.repository.RestaurantRepository
import com.leoapps.testtask.detail.DetailViewModel
import com.leoapps.testtask.main.presentation.RestaurantViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val koinModule = module {
    single<RestaurantRepository> { RestaurantRepositoryImpl() }

    viewModelOf(::RestaurantViewModel)
    viewModel { (menuItemId: Int) ->
        DetailViewModel(
            initialItemId = menuItemId,
            repository = get(),
        )
    }
}