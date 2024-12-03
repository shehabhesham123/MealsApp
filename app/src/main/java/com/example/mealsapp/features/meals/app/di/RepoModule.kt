package com.example.mealsapp.features.meals.app.di

import com.example.mealsapp.features.meals.data.repo.MealsLocalHandler
import com.example.mealsapp.features.meals.data.repo.MealsRepoImpl
import com.example.mealsapp.features.meals.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun providesMealsRepo(
        /*api: ApiServices,
        database: MealsDatabase,*/
        handler: MealsLocalHandler
    ): MealsRepo {
        return MealsRepoImpl(handler/*,api, database*/)
    }
}