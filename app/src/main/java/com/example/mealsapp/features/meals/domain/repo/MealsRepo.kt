package com.example.mealsapp.features.meals.domain.repo

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.features.meals.app.viewmodel.model.Category
import com.example.mealsapp.features.meals.app.viewmodel.model.Meal

abstract class MealsRepo() {
    abstract suspend fun getMealsCategories(): Either<Failure, List<Category>>
    abstract suspend fun getMeals(letter:Char): Either<Failure, List<Meal>>
}