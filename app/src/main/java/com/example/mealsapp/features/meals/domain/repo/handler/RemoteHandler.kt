package com.example.mealsapp.features.meals.domain.repo.handler

import android.util.Log
import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import retrofit2.Call

private const val TAG = "RemoteHandler"

abstract class RemoteHandler<in Params, out Type : Any, ApiServices : BasicApi>(
    protected val apiServices: ApiServices,
    successor: Handler<Params, Type>?
) : Handler<Params, Type>(successor) {

    protected fun <T, R : Any> request(
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