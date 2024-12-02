package com.example.mealsapp.features.meals.app.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mealsapp.features.meals.app.viewmodel.viewmodel.MealsViewModel

@Composable
fun Meals(viewModel: MealsViewModel,navController: NavController){
    LaunchedEffect(Unit) {
        viewModel.getMeals()
    }

    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn {
            items(viewModel.meals){
                Text(text = it.toString())
            }
        }
    }
}