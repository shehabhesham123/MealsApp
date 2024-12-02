package com.example.mealsapp.features.meals.domain.usecase

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.core.usecase.Usecase
import com.example.mealsapp.features.meals.app.viewmodel.model.Meal
import com.example.mealsapp.features.meals.domain.repo.MealsRepo

class GetMeals(private val mealsRepo: MealsRepo) : Usecase<Char, List<Meal>>() {
    override suspend fun run(params: Char): Either<Failure, List<Meal>> {
        return mealsRepo.getMeals(params)
    }
}