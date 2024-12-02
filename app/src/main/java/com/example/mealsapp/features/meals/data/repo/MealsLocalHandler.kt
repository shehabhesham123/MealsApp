package com.example.mealsapp.features.meals.data.repo

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import com.example.mealsapp.core.usecase.Usecase
import com.example.mealsapp.features.meals.app.viewmodel.model.Category
import com.example.mealsapp.features.meals.data.local.Dao
import com.example.mealsapp.features.meals.data.repo.handler.Handler
import com.example.mealsapp.features.meals.data.repo.handler.LocalHandler

class MealsLocalHandler(dao: Dao, successor: Handler<Usecase.None, List<Category>>?) :
    LocalHandler<Usecase.None, List<Category>, Dao>(dao, successor) {

    override fun handleRequest(request: Usecase.None?): Either<Failure, List<Category>> {
        val categories = dao.getCategories()
        return if (categories.isEmpty())
            successor!!.handleRequest(request)
        else Either.Right(categories.map { it.toCategory() })
    }
}