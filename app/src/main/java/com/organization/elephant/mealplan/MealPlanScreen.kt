package com.organization.elephant.mealplannew

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun MealPlanScreen(
    navigateToNewMealPlanScreen:()->Unit,
    navigateToArchivesMealPlanScreen:()->Unit
) {
    PrincipalTitle(
        title = "Meal Plan",
        icon = {
            Row(verticalAlignment = Alignment.CenterVertically)
            {
                Image(
                    modifier=Modifier.clickable { navigateToNewMealPlanScreen() },
                    painter = painterResource(id = R.drawable.ic_add_image_button),
                    contentDescription = "add new meal plan icon"
                )
                Image(
                    modifier=Modifier.clickable {navigateToArchivesMealPlanScreen() },
                    painter = painterResource(id = R.drawable.ic_archived),
                    contentDescription = "Archived Meal Plans"
                )
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun MealPlanScreenPreview() {
    ElephantTheme {
        MealPlanScreen(
            navigateToNewMealPlanScreen={},
            navigateToArchivesMealPlanScreen={}
        )
    }
}