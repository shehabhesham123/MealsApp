package com.example.mealsapp.features.meals.data.repo

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.features.meals.app.viewmodel.model.Category
import com.example.mealsapp.features.meals.data.remote.ApiServices
import com.example.mealsapp.features.meals.domain.entity.MealsCategoriesResponse
import com.example.mealsapp.features.meals.domain.repo.MealsRepo
import retrofit2.Call

class MealsRepoImpl(private val api: ApiServices) : MealsRepo() {
    override suspend fun getMealsCategories(): Either<Failure, List<Category>> {
        return request(
            api.getMealsCategories(),
            { response -> response.categories.map { it.toCategory() } },
            MealsCategoriesResponse(emptyList())
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
            Either.Left(Failure.ServerFailure)
        }
    }
}