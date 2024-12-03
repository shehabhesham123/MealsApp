package com.example.mealsapp.features.meals.data.repo

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.core.usecase.Usecase
import com.example.mealsapp.features.meals.app.viewmodel.model.Category
import com.example.mealsapp.features.meals.data.remote.ApiServices
import com.example.mealsapp.features.meals.domain.entity.MealsCategoriesResponse
import com.example.mealsapp.features.meals.domain.repo.handler.Handler
import com.example.mealsapp.features.meals.domain.repo.handler.RemoteHandler

class MealsRemoteHandler(api: ApiServices, successor: Handler<Usecase.None, List<Category>>?) :
    RemoteHandler<Usecase.None, List<Category>, ApiServices>(api, successor) {
    override suspend fun handleRequest(request: Usecase.None?): Either<Failure, List<Category>> {
        return request(
            apiServices.getMealsCategories(),
            { response -> response.categories.map { it.toCategory() } },
            MealsCategoriesResponse(emptyList())
        )
    }
}