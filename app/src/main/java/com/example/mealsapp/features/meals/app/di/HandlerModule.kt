package com.example.mealsapp.features.meals.app.di

import com.example.mealsapp.features.meals.data.local.MealsDatabase
import com.example.mealsapp.features.meals.data.remote.ApiServices
import com.example.mealsapp.features.meals.data.repo.MealsLocalHandler
import com.example.mealsapp.features.meals.data.repo.MealsRemoteHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HandlerModule {
    @Provides
    fun providesLocalMealsHandler(
        database: MealsDatabase,
        mealsRemoteHandler: MealsRemoteHandler
    ): MealsLocalHandler {
        return MealsLocalHandler(database.dao(), mealsRemoteHandler)
    }

    @Provides
    fun providesRemoteMealsHandler(api: ApiServices): MealsRemoteHandler {
        return MealsRemoteHandler(api, null)
    }

}