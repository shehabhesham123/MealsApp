package com.example.mealsapp.features.meals.domain.entity

import com.example.mealsapp.features.meals.app.viewmodel.model.Category

data class CategoryEntity(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
) {
    fun toCategory() = Category(idCategory, strCategory, strCategoryDescription, strCategoryThumb)
}