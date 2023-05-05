package com.organization.elephant.mealplan.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.mealplan.MealPlanScreen
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun NewMealPlanScreen() {
    PrincipalTitle(
        title = "Add New Meal Plan",
        icon = {})
}

@Preview(showSystemUi = true)
@Composable
fun NewMealPlanScreenPreview() {
    ElephantTheme {
        NewMealPlanScreen()
    }
}