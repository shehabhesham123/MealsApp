package com.example.mealsapp.features.meals.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mealsapp.features.meals.domain.entity.CategoryEntity
import com.example.mealsapp.features.meals.domain.repo.handler.BasicDao

@Dao
interface Dao : BasicDao {
    @Insert()
    suspend fun insertCategory(categoryEntity: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categoryEntities: List<CategoryEntity>)

    @Query("select * from category")
    suspend fun getCategories(): List<CategoryEntity>
}