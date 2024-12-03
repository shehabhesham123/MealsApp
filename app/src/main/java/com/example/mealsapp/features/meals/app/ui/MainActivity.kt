package com.example.mealsapp.features.meals.app.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.mealsapp.features.meals.app.ui.navigation.MainNavHot
import com.example.mealsapp.features.meals.data.local.MealsDatabase
import com.example.mealsapp.features.meals.domain.entity.CategoryEntity
import com.example.mealsapp.ui.theme.MealsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/*private const val TAG = "MainActivity"*/
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var database: MealsDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MainNavHot()
                    }
                }
            }
        }
        /*lifecycleScope.launch(Dispatchers.IO) {
            val id = database.dao().insertCategory(CategoryEntity("5", "name2", "des", ""))
            Log.d(TAG, "onCreate: id:${id}")
        }*/
    }
}