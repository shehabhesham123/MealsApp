package com.example.mealsapp.features.meals.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mealsapp.features.meals.domain.entity.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1)
abstract class MealsDatabase : RoomDatabase() {
    abstract fun dao(): Dao
}