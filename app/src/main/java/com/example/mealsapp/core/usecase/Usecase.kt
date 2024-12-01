package com.example.mealsapp.core.usecase

import com.example.mealsapp.core.failure.Failure
import com.example.mealsapp.core.funcational.Either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class Usecase<in Params, out Type : Any> {
    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        param: Params,
        scope: CoroutineScope,
        onResult: (Either<Failure, Type>) -> Unit
    ) {
        scope.launch(Dispatchers.IO) {
            val deferredJob = async { run(param) }
            onResult(deferredJob.await())
        }
    }

    class None()
}