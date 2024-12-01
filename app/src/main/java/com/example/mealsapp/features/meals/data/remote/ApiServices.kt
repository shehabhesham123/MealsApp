package com.example.mealsapp.features.meals.data.remote

import com.example.mealsapp.features.meals.domain.entity.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("categories.php")
    fun getMealsCategories(): Call<MealsCategoriesResponse>
}