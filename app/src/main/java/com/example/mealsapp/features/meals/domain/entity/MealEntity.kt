package com.example.mealsapp.features.meals.domain.entity

import com.example.mealsapp.features.meals.app.viewmodel.model.Meal

data class MealEntity(
    val idMeal: String,
    val strArea: String?,
    val strCategory: String?,
    val strInstructions: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strTags: String?,
    val strYoutube: String?
){
    fun toMeal() = Meal(idMeal,strArea,strCategory, strInstructions, strMeal, strMealThumb, strTags, strYoutube)
}