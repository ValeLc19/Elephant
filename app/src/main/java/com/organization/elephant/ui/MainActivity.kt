package com.organization.elephant.ui

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
import com.organization.elephant.ui.food.FoodScreen
import com.organization.elephant.ui.grocery.GroceryScreen
import com.organization.elephant.ui.grocerybuyingitem.GroceryBuyingItemScreen
import com.organization.elephant.ui.grocerybuyingitem.GroceryBuyingItemViewModel
import com.organization.elephant.ui.grocerylistitem.GroceryListScreen
import com.organization.elephant.ui.grocerylistitem.GroceryListViewModel
import com.organization.elephant.ui.home.HomeScreen
import com.organization.elephant.ui.mealplan.MealPlanScreen
import com.organization.elephant.ui.mealplan.MealPlanViewModel
import com.organization.elephant.ui.mealplanlist.MealPlanListScreen
import com.organization.elephant.ui.mealplanlist.MealPlanListViewModel
import com.organization.elephant.ui.mealplannew.NewMealPlanScreen
import com.organization.elephant.ui.mealplannew.NewMealPlanViewModel
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
                                },
                                navigateToGroceryScreen = {
                                    navController.navigate(Screen.GroceryScreen.route)
                                }
                            )
                        }
                        composable(Screen.MealPlanScreen.route) {
                            val viewModel: MealPlanViewModel by viewModels()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            MealPlanScreen(
                                state = state,
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
                        composable(Screen.GroceryScreen.route) {
                            GroceryScreen(
                                navigateToGroceryListScreen = {
                                    navController.navigate(Screen.GroceryListScreen.route)
                                }
                            )
                        }
                        composable(Screen.GroceryListScreen.route) {
                            val viewModel: GroceryListViewModel by viewModels()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            GroceryListScreen(
                                state = state,
                                onUpdateNewItem = {
                                    viewModel.updateNewItem(updatedItem = it)
                                },
                                addNewItemToList = {
                                    viewModel.addNewItemToList()
                                },
                                deleteItemToList = { index ->
                                    viewModel.deleteItemOnList(indexToRemove = index)
                                }

                            )
                        }
                        composable(Screen.GroceryBuyingItemScreen.route) {
                            val viewModel: GroceryBuyingItemViewModel by viewModels()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            GroceryBuyingItemScreen(
                                state = state,
                                onMoveItemToCart={ groceryItem->
                                   viewModel.addItemToCart(groceryItem=groceryItem)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}