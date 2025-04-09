package com.leoapps.testtask.main.presentation.model

data class Category(
    val id: Int,
    val title: String,
    val items: List<MenuItem>,
)