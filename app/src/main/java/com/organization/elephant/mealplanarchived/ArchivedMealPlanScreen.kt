package com.organization.elephant.mealplannew.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.mealplannew.MealPlanScreen
import com.organization.elephant.ui.theme.ElephantTheme

@Composable()
fun ArchivedMealPlansScreen(){
    PrincipalTitle(
        title = "All New Meal Plans",
        icon = {})
}

@Preview(showSystemUi = true)
@Composable
fun ArchivedMealPlansScreenPreview() {
    ElephantTheme {
        MealPlanScreen(
            navigateToNewMealPlanScreen={},
            navigateToArchivesMealPlanScreen={}
        )
    }
}