package com.example.mealsapp.core.platform

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mealsapp.core.failure.Failure

abstract class BasicViewModel : ViewModel() {
    var failure by mutableStateOf<Failure?>(null)
        private set
    fun handleFailure(failure: Failure) {
        this.failure = failure
    }
}