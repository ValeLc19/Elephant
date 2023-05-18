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
import com.organization.elephant.mealplanlist.MealPlanListScreen
import com.organization.elephant.mealplanlist.MealPlanListViewModel
import com.organization.elephant.mealplan.MealPlanScreen
import com.organization.elephant.mealplannew.NewMealPlanViewModel
import com.organization.elephant.mealplannew.NewMealPlanScreen
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
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(Screen.HomeScreen.route) {
                            HomeScreen(
                                navigateToFood = {
                                    navController.navigate(Screen.FoodScreen.route)
                                }
                            )
                        }
                        composable(Screen.FoodScreen.route) {
                            FoodScreen(
                                navigateToMealPlan = {
                                    navController.navigate(Screen.MealPlanScreen.route)
                                }
                            )
                        }
                        composable(Screen.MealPlanScreen.route) {
                            MealPlanScreen(
                                navigateToNewMealPlanScreen = {
                                    navController.navigate(Screen.NewMealPlanScreen.route)
                                },
                                navigateToArchivesMealPlanScreen = {
                                    navController.navigate(Screen.MealPlanListScreen.route)
                                }
                            )
                        }
                        composable(Screen.NewMealPlanScreen.route) {
                            val viewModel: NewMealPlanViewModel by viewModels()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            NewMealPlanScreen(
                                state = state,
                                onUpdateMealPlan = { updatedMealPlan ->
                                    viewModel.updateMealPlan(updatedMealPlan)
                                }
                            )
                        }
                        composable(Screen.MealPlanListScreen.route) {
                            val viewModel: MealPlanListViewModel by viewModels()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            MealPlanListScreen(
                                state = state,
                                onMealPlanPressed = {
                                    navController.navigate(Screen.NewMealPlanScreen.route)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}