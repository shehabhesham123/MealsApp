package com.example.mealsapp.features.meals.app.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mealsapp.features.meals.app.ui.navigation.Routes
import com.example.mealsapp.features.meals.app.viewmodel.viewmodel.MealsCategoriesViewModel

@Composable
fun MealsCategories(viewModel: MealsCategoriesViewModel, navController: NavController) {
    LaunchedEffect(Unit) {
        viewModel.getMeals()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(viewModel.categories) {
                Text(text = it.strCategory, modifier = Modifier.clickable {
                    navController.navigate(Routes.MEALS)
                })
            }
        }
    }
}
