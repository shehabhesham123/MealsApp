package com.example.mealsapp.features.meals.domain.usecase

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.core.usecase.Usecase
import com.example.mealsapp.features.meals.app.viewmodel.model.Category
import com.example.mealsapp.features.meals.domain.repo.MealsRepo

class GetMealsCategories(private val repo: MealsRepo) : Usecase<Usecase.None, List<Category>>() {
    override suspend fun run(params: None): Either<Failure, List<Category>> {
        return repo.getMealsCategories()
    }
}