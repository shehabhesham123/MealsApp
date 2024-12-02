package com.example.mealsapp.features.meals.app.viewmodel.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.mealsapp.core.platform.BasicViewModel
import com.example.mealsapp.core.usecase.Usecase
import com.example.mealsapp.features.meals.app.viewmodel.model.Meal
import com.example.mealsapp.features.meals.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "MealsViewModel"
@HiltViewModel
class MealsViewModel @Inject constructor(private val getMeals: GetMeals) : BasicViewModel() {
    var meals by mutableStateOf<List<Meal>>(emptyList())
        private set

    fun getMeals() {
        getMeals.invoke(Usecase.None(), viewModelScope, {
            it.fold(::handleFailure, ::handleMeals)
        })
    }

    fun handleMeals(meals: List<Meal>) {
        meals.forEach {
            Log.d(TAG, "handleMeals: ${it.strMeal}")
        }
        this.meals = meals
    }
}