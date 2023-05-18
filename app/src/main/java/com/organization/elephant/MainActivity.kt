package com.organization.elephant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.organization.elephant.food.FoodScreen
import com.organization.elephant.home.HomeScreen
import com.organization.elephant.mealplannew.MealPlanScreen
import com.organization.elephant.mealplannew.NewMealPlanViewModel
import com.organization.elephant.mealplannew.screens.ArchivedMealPlansScreen
import com.organization.elephant.mealplannew.screens.NewMealPlanScreen
import com.organization.elephant.ui.theme.ElephantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ElephantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "Home"
                    ) {
                        composable("Home") {
                            HomeScreen(
                                navigateToFood = {
                                    navController.navigate("Food")
                                }
                            )
                        }
                        composable("Food") {
                            FoodScreen(
                                navigateToMealPlan = {
                                    navController.navigate("Meal Plan")
                                }
                            )
                        }
                        composable("Meal Plan") {
                            MealPlanScreen(
                                navigateToNewMealPlanScreen = {
                                    navController.navigate("New Meal Plan Screen")
                                },
                                navigateToArchivesMealPlanScreen = {
                                    navController.navigate("Archived Meal Plan Screen")
                                }
                            )
                        }
                        composable("New Meal Plan Screen") {
                            val viewModel: NewMealPlanViewModel by viewModels()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            NewMealPlanScreen(
                                state = state,
                                onUpdateMealPlan = { updatedMealPlan ->
                                    viewModel.updateMealPlan(updatedMealPlan)
                                }
                            )
                        }
                        composable("Archived Meal Plan Screen") {
                            ArchivedMealPlansScreen()
                        }
                    }
                }
            }
        }
    }
}