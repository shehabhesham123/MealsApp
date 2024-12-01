package com.example.mealsapp.features.meals.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mealsapp.features.meals.data.repo.handler.BasicDao
import com.example.mealsapp.features.meals.domain.entity.CategoryEntity

@Dao
interface Dao : BasicDao {
    @Insert
    fun insertCategory(categoryEntity: CategoryEntity)

    @Query("select * from category")
    fun getCategories(): List<CategoryEntity>
}