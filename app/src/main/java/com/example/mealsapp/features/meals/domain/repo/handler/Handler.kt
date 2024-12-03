package com.example.mealsapp.features.meals.domain.repo.handler

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either

abstract class Handler<in Params, out Type : Any>(val successor: Handler<Params, Type>?) {
    abstract suspend fun handleRequest(request: Params?): Either<Failure, Type>
}