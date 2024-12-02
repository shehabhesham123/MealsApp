package com.example.mealsapp.features.meals.data.repo

import android.util.Log
import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.features.meals.app.viewmodel.model.Category
import com.example.mealsapp.features.meals.app.viewmodel.model.Meal
import com.example.mealsapp.features.meals.data.local.MealsDatabase
import com.example.mealsapp.features.meals.data.remote.ApiServices
import com.example.mealsapp.features.meals.domain.entity.MealsCategoriesResponse
import com.example.mealsapp.features.meals.domain.entity.MealsResponse
import com.example.mealsapp.features.meals.domain.repo.MealsRepo
import retrofit2.Call

private const val TAG = "MealsRepoImpl"

class MealsRepoImpl(
    private val api: ApiServices,
    private val database: MealsDatabase
) :
    MealsRepo() {
    override suspend fun getMealsCategories(): Either<Failure, List<Category>> {
        return request(
            api.getMealsCategories(),
            { response -> response.categories.map { it.toCategory() } },
            MealsCategoriesResponse(emptyList())
        )
    }

    override suspend fun getMeals(letter: Char): Either<Failure, List<Meal>> {
        return request(
            api.getMeals(letter),
            { mealsResponse ->
                mealsResponse.meals.map { it.toMeal() }
            }, MealsResponse(emptyList())
        )
    }

    private fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerFailure)
            }
        } catch (exception: Throwable) {
            Log.d(TAG, "request: ${exception.message}")
            Either.Left(Failure.ServerFailure)
        }
    }
}