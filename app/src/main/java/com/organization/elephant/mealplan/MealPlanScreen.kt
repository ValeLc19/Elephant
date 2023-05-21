package com.organization.elephant.mealplan

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.data.models.*
import com.organization.elephant.mealplan.components.MealPlanCard
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun MealPlanScreen(
    state: MealPlanState,
    navigateToNewMealPlanScreen: () -> Unit,
    navigateToArchivesMealPlanScreen: () -> Unit
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
    ) {
        PrincipalTitle(
            title = state.title,
            icon = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier.clickable { navigateToNewMealPlanScreen() },
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "add new meal plan icon"
                    )
                    Image(
                        modifier = Modifier.clickable { navigateToArchivesMealPlanScreen() },
                        painter = painterResource(id = R.drawable.ic_archived),
                        contentDescription = "Archived Meal Plans"
                    )
                }
            }
        )
        Box(
            modifier = Modifier
                .height(267.dp)
                .fillMaxWidth()
                .padding(10.dp)
                .border(
                    width = 5.dp,
                    shape = RoundedCornerShape(30.dp),
                    color = colorResource(id = R.color.attribute_food)
                )
        ) {}

        state.mealPlan.mealGroups.forEach {
            MealPlanCard(
                mealGroup = it
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MealPlanScreenPreview() {
    ElephantTheme {
        MealPlanScreen(
            state = MealPlanState(
                title = "Meal Plan",
                mealPlan =  MealPlan(
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
                                    quantity = 120.0,
                                    name = "apple",
                                    units = FoodMeasurementUnit.GRAMS,
                                ),
                                MealItem(
                                    quantity = 50.0,
                                    name = "Milk",
                                    units = FoodMeasurementUnit.MILLILITERS,
                                )
                            )
                        ),
                        MealGroup(
                            type = MealGroupType.SNACK,
                            mealItems = listOf(
                                MealItem(
                                    quantity = 30.0,
                                    name = "egg whites",
                                    units = FoodMeasurementUnit.GRAMS,
                                ),
                                MealItem(
                                    quantity = 50.0,
                                    name = "Milk",
                                    units = FoodMeasurementUnit.MILLILITERS,
                                )
                            )
                        ),
                        MealGroup(
                            type = MealGroupType.LUNCH,
                            mealItems = listOf(
                                MealItem(
                                    quantity = 200.0,
                                    name = "chicken",
                                    units = FoodMeasurementUnit.OUNCES,
                                ),
                                MealItem(
                                    quantity = 50.0,
                                    name = "Milk",
                                    units = FoodMeasurementUnit.MILLILITERS,
                                )
                            )
                        ),
                        MealGroup(
                            type = MealGroupType.SNACK,
                            mealItems = listOf(
                                MealItem(
                                    quantity = 50.0,
                                    name = "Milk",
                                    units = FoodMeasurementUnit.MILLILITERS,
                                ),
                                MealItem(
                                    quantity = 50.0,
                                    name = "Milk",
                                    units = FoodMeasurementUnit.MILLILITERS,
                                )

                            )
                        ),
                        MealGroup(
                            type = MealGroupType.DINNER,
                            mealItems = listOf(
                                MealItem(
                                    quantity = 1.0,
                                    name = "Nuts",
                                    units = FoodMeasurementUnit.GRAMS,
                                ),
                                MealItem(
                                    quantity = 20.5,
                                    name = "Milk",
                                    units = FoodMeasurementUnit.MILLILITERS,
                                )
                            )
                        )
                    ),
                ),
            ),
            navigateToNewMealPlanScreen = {},
            navigateToArchivesMealPlanScreen = {}
        )
    }
}