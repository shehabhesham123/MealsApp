package com.example.mealsapp.core.failure

sealed class Failure {
    data object ServerFailure : Failure()
    data object NetworkFailure : Failure()
    data object UnknownFailure : Failure()
    class FeatureFailure(val message: String) : Failure()
}