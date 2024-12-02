package com.example.mealsapp.features.meals.app.di

import com.example.mealsapp.features.meals.domain.repo.MealsRepo
import com.example.mealsapp.features.meals.domain.usecase.GetMeals
import com.example.mealsapp.features.meals.domain.usecase.GetMealsCategories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {
    @Provides
    fun providesGetMealsCategories(mealsRepo: MealsRepo): GetMealsCategories {
        return GetMealsCategories(mealsRepo)
    }

    @Provides
    fun providesGetMeals(mealsRepo: MealsRepo): GetMeals {
        return GetMeals(mealsRepo)
    }
}