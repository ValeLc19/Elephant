package com.organization.elephant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.organization.elephant.food.FoodScreen
import com.organization.elephant.home.HomeScreen
import com.organization.elephant.mealplan.MealPlanScreen
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
                    NavHost(navController = navController, startDestination = "Home") {
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
                        composable("Meal Plan"){
                            MealPlanScreen()
                        }
                    }
                }
            }
        }
    }
}