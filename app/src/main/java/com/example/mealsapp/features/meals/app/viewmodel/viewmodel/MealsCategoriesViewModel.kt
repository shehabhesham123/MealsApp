package com.example.mealsapp.features.meals.app.viewmodel.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.mealsapp.core.platform.BasicViewModel
import com.example.mealsapp.core.usecase.Usecase
import com.example.mealsapp.features.meals.app.viewmodel.model.Category
import com.example.mealsapp.features.meals.domain.usecase.GetMealsCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "MealsViewModel"
@HiltViewModel
class MealsCategoriesViewModel @Inject constructor(private val getMealsCategories: GetMealsCategories) :
    BasicViewModel() {
    var categories by mutableStateOf(emptyList<Category>())
        private set

    fun getMeals() {
        getMealsCategories(Usecase.None(), viewModelScope) {
            it.fold(::handleFailure, ::handleCategories)
        }
    }

    fun handleCategories(categories: List<Category>) {
        categories.forEach {
            Log.d(TAG, "handleCategories: ${it.strCategory}")
        }
        this.categories = categories
    }
}