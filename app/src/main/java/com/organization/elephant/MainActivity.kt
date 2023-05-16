package com.organization.elephant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.organization.elephant.data.models.*
import com.organization.elephant.food.FoodScreen
import com.organization.elephant.home.HomeScreen
import com.organization.elephant.mealplan.MealPlanScreen
import com.organization.elephant.mealplan.screens.ArchivedMealPlansScreen
import com.organization.elephant.mealplan.screens.NewMealPlanScreen
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
                        startDestination = "New Meal Plan Screen"
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

                            var mealPlan by remember {
                                mutableStateOf(
                                    MealPlan(
                                        startDateInMillis = 1683244800000,
                                        endDateInMillis = 1685923200000,
                                        carbs = 160.0,
                                        fat = 30.0,
                                        protein = 160.0,
                                        calories = 1612.0,
                                        mealGroups = listOf(
                                            MealGroup(
                                                type = MealGroupType.BREAKFAST,
                                                mealItems = listOf(
                                                    MealItem(
                                                        quantity = 120.0f,
                                                        name = "apple",
                                                        units = FoodMeasurementUnit.GRAMS,
                                                    ),
                                                    MealItem(
                                                        quantity = 50.0f,
                                                        name = "Milk",
                                                        units = FoodMeasurementUnit.MILLILITERS,
                                                    )
                                                )
                                            ),
                                            MealGroup(
                                                type = MealGroupType.SNACK,
                                                mealItems = listOf(
                                                    MealItem(
                                                        quantity = 30.0f,
                                                        name = "egg whites",
                                                        units = FoodMeasurementUnit.GRAMS,
                                                    ),
                                                    MealItem(
                                                        quantity = 50.0f,
                                                        name = "Milk",
                                                        units = FoodMeasurementUnit.MILLILITERS,
                                                    )
                                                )
                                            ),
                                            MealGroup(
                                                type = MealGroupType.LUNCH,
                                                mealItems = listOf(
                                                    MealItem(
                                                        quantity = 200.0f,
                                                        name = "chicken",
                                                        units = FoodMeasurementUnit.OUNCES,
                                                    ),
                                                    MealItem(
                                                        quantity = 50.0f,
                                                        name = "Milk",
                                                        units = FoodMeasurementUnit.MILLILITERS,
                                                    )
                                                )
                                            ),
                                            MealGroup(
                                                type = MealGroupType.SNACK,
                                                mealItems = listOf(
                                                    MealItem(
                                                        quantity = 50.0f,
                                                        name = "Milk",
                                                        units = FoodMeasurementUnit.MILLILITERS,
                                                    ),
                                                    MealItem(
                                                        quantity = 50.0f,
                                                        name = "Milk",
                                                        units = FoodMeasurementUnit.MILLILITERS,
                                                    )

                                                )
                                            ),
                                            MealGroup(
                                                type = MealGroupType.DINNER,
                                                mealItems = listOf(
                                                    MealItem(
                                                        quantity = 1.0f,
                                                        name = "Nuts",
                                                        units = FoodMeasurementUnit.GRAMS,
                                                    ),
                                                    MealItem(
                                                        quantity = 20.5f,
                                                        name = "Milk",
                                                        units = FoodMeasurementUnit.MILLILITERS,
                                                    )
                                                )
                                            )
                                        ),
                                    )
                                )
                            }

                            NewMealPlanScreen(
                                mealPlan = mealPlan,
                                onUpdateMealPlan = { newMealPlan ->
                                    mealPlan = newMealPlan
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