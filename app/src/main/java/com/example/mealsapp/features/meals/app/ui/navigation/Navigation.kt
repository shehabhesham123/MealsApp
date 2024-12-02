package com.example.mealsapp.features.meals.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealsapp.features.meals.app.ui.screen.MealsCategories
import com.example.mealsapp.features.meals.app.viewmodel.viewmodel.MealsCategoriesViewModel


@Composable
fun MainNavHot() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MEALS_CATEGORIES) {
        composable(Routes.MEALS_CATEGORIES) {
            val viewModel = hiltViewModel<MealsCategoriesViewModel>()
            MealsCategories(viewModel = viewModel, navController = navController)
            //
        }

        /*composable(
            Routes.MEALS,
            arguments = listOf(navArgument("categoryId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
        }*/
    }
}
