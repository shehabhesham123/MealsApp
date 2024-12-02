package com.example.mealsapp.features.meals.app.di

import android.content.Context
import androidx.room.Room
import com.example.mealsapp.features.meals.data.local.MealsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): MealsDatabase {
        return Room.databaseBuilder(context, MealsDatabase::class.java, "MealsDatabase").build()
    }
}