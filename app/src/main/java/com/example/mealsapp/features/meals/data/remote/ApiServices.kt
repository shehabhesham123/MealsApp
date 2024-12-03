package com.example.mealsapp.features.meals.data.remote

import com.example.mealsapp.features.meals.domain.repo.handler.BasicApi
import com.example.mealsapp.features.meals.domain.entity.MealsCategoriesResponse
import com.example.mealsapp.features.meals.domain.entity.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices : BasicApi {
    @GET("categories.php")
    fun getMealsCategories(): Call<MealsCategoriesResponse>

    @GET("search.php")
    fun getMeals(@Query("f") letter: Char): Call<MealsResponse>
}