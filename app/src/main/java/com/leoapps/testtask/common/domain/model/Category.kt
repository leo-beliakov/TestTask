package com.leoapps.testtask.common.domain.model

data class Category(
    val id: Int,
    val title: String,
    val items: List<MenuItem>
)