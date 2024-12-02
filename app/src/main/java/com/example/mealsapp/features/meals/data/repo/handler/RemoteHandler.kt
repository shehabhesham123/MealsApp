package com.example.mealsapp.features.meals.data.repo.handler

abstract class RemoteHandler<in Params, out Type : Any, ApiServices : BasicApi>(
    protected val apiServices: ApiServices,
    successor: Handler<Params, Type>?
) : Handler<Params, Type>(successor)