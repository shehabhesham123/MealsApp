package com.example.mealsapp.features.meals.app.viewmodel.model

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
) {
    companion object {
        fun empty() = Category("", "", "", "")
    }
}