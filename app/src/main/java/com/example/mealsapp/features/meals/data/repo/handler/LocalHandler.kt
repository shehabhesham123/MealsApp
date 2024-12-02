package com.example.mealsapp.features.meals.data.repo.handler

abstract class LocalHandler<in Params, out Type : Any, Dao : BasicDao>(
    protected val dao: Dao,
    successor: Handler<Params, Type>?
) : Handler<Params, Type>(successor)