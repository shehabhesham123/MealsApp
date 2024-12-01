package com.example.mealsapp.features.meals.domain.repo

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.features.meals.app.viewmodel.model.Category

abstract class MealsRepo() {
    abstract suspend fun getMealsCategories(): Either<Failure, List<Category>>
}