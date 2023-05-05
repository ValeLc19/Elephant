package com.organization.elephant.food


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.food.components.FoodScreenCard
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun FoodScreen(
    navigateToMealPlan: () -> Unit
) {
    Column() {
        PrincipalTitle(
            title = "Food",
            icon = {},
        )
        FoodScreenCard(
            titleItem = "Meal Plan",
            iconItemID = R.drawable.ic_meal_plan,
            onClick = { navigateToMealPlan() }
        )
        FoodScreenCard(
            titleItem = "Grocery Store List",
            iconItemID = R.drawable.ic_grocery,
            onClick = {}
        )
        FoodScreenCard(
            titleItem = "Recipes",
            iconItemID = R.drawable.ic_recipes,
            onClick = {}
        )
        FoodScreenCard(
            titleItem = "Food Waste",
            iconItemID = R.drawable.ic_food_waste,
            onClick = {}
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FoodScreenPreview() {
    ElephantTheme {
        FoodScreen(
            navigateToMealPlan = {}
        )
    }
}