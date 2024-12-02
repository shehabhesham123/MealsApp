package com.example.mealsapp.features.meals.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mealsapp.features.meals.app.viewmodel.model.Category

@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
) {
    fun toCategory() = Category(idCategory, strCategory, strCategoryDescription, strCategoryThumb)
}