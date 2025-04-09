package com.leoapps.testtask

import android.app.Application
import com.leoapps.testtask.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RestaurantApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RestaurantApp)
            modules(koinModule)
        }
    }
} 