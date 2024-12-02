package com.example.mealsapp.features.meals.data.repo

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.core.usecase.Usecase
import com.example.mealsapp.features.meals.app.viewmodel.model.Category
import com.example.mealsapp.features.meals.data.remote.ApiServices
import com.example.mealsapp.features.meals.data.repo.handler.Handler
import com.example.mealsapp.features.meals.data.repo.handler.RemoteHandler
import com.example.mealsapp.features.meals.domain.entity.MealsCategoriesResponse
import retrofit2.Call

class MealsRemoteHandler(api: ApiServices, successor: Handler<Usecase.None, List<Category>>?) :
    RemoteHandler<Usecase.None, List<Category>, ApiServices>(api, successor) {
    override fun handleRequest(request: Usecase.None?): Either<Failure, List<Category>> {
        return request(
            apiServices.getMealsCategories(),
            { response -> response.categories.map { it.toCategory() } },
            MealsCategoriesResponse(emptyList())
        )
    }

    private fun <T, R : Any> request(
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