package com.organization.elephant.ui.mealplanlist

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.data.models.*
import com.organization.elephant.ui.mealplanlist.components.MealPlanListCard
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun MealPlanListScreen(
    state: MealPlanListState,
    onMealPlanPressed: (selectedMealPlan: MealPlan) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 35.dp, end = 35.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = state.title,
                fontSize = 30.sp,
            )
        }
        Divider(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .padding(top = 10.dp),
            thickness = 2.dp
        )
        state.mealPlans.forEach {
            Row(
                modifier = Modifier.padding(
                    top = 10.dp,
                    end = 30.dp,
                    start = 30.dp
                )
            ) {
                MealPlanListCard(
                    starDate = it.formattedStartDate,
                    endDate = it.formattedEndDate,
                    calories = it.calories,
                    onClick = {
                        onMealPlanPressed(it)
                    }
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MealPlanListScreenPreview() {
    ElephantTheme {
        MealPlanListScreen(
            state = MealPlanListState(
                title = "All Meals Plans",
                mealPlans = listOf(
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
            ),
            onMealPlanPressed = {}
        )
    }
}