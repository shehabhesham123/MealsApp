package com.example.mealsapp.features.meals.domain.repo.handler

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either

abstract class LocalHandler<in Params, out Type : Any, Dao : BasicDao>(
    protected val dao: Dao,
    successor: Handler<Params, Type>?
) : Handler<Params, Type>(successor)