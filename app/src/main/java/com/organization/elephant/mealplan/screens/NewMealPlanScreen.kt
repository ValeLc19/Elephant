package com.organization.elephant.mealplan.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.data.models.*
import com.organization.elephant.ui.theme.Background
import com.organization.elephant.ui.theme.ElephantTheme
import kotlin.math.round

@Composable
fun NewMealPlanScreen(
    mealPlan: MealPlan
) {

    Column(
        modifier=Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrincipalTitle(
            title = "Add New Meal Plan",
            icon = {}
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 5.dp)
                .background(colorResource(id = R.color.background_meal_plan).copy(alpha = 0.12f))

        ) {
            Column() {
                Row(
                    modifier = Modifier.padding(start = 10.dp),
                ) {
                    Text(
                        modifier = Modifier.alignByBaseline(),
                        text = "Start: ",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold

                    )
                    Text(
                        modifier = Modifier.alignByBaseline(),
                        text = mealPlan.formattedStartDate,
                        fontSize = 12.sp,
                    )
                }
                Row(
                    modifier = Modifier.padding(start = 10.dp),
                ) {
                    Text(
                        modifier = Modifier.alignByBaseline(),
                        text = "End: ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.alignByBaseline(),
                        text = mealPlan.formattedEndDate,
                        fontSize = 12.sp,
                    )
                }
            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 5.dp)
                .background(
                    colorResource(
                        id = R.color.background_meal_plan
                    ).copy(alpha = 0.12f)
                )
        ) {
            Column(
                modifier = Modifier.padding(start = 10.dp),
            ) {
                Text(
                    text = "Nutritional Information",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Carbs: ${mealPlan.carbs}",
                )
                Text(
                    text = "Fat: ${mealPlan.fat}",
                )
                Text(
                    text = "Protein: ${mealPlan.protein}",
                )
                Text(
                    text = "Calories: ${mealPlan.calories}",
                )
            }
        }

        mealPlan.mealGroups.forEach { mealGroup ->
            var isMealGroupExpanded by remember { mutableStateOf(false) }
            Box(
                modifier = Modifier
                    .clickable { isMealGroupExpanded = !isMealGroupExpanded }
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 5.dp)
                    .background(colorResource(id = R.color.background_meal_plan).copy(alpha = 0.12f))
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = mealGroup.type.displayName,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            modifier = Modifier.clickable { },
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = "edit icon",
                        )
                    }
                    if (isMealGroupExpanded) {
                        mealGroup.mealItems.forEach { mealItem ->
                            Column() {
                                Text(text = "${mealItem.quantity} ${mealItem.units.abbreviation} ${mealItem.name}")
                                Divider(
                                    modifier = Modifier
                                        .padding(end = 75.dp, top = 1.dp, bottom = 4.dp),
                                    thickness = 2.dp
                                )
                            }
                        }
                    }

                }


            }
        }

        Button(
            modifier = Modifier
                .padding(end = 10.dp,top=30.dp),
            onClick = {},
            shape = RoundedCornerShape(3.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor= colorResource(id = R.color.save_button)
            )
        ) {
            Text(text = "Save")
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun NewMealPlanScreenPreview() {
    ElephantTheme {
        NewMealPlanScreen(
            mealPlan = MealPlan(
                startDateInMillis = 1683244800000,
                endDateInMillis = 1685923200000,
                carbs = 160,
                fat = 30,
                protein = 160,
                calories = 1612,
                mealGroups = listOf(
                    MealGroup(
                        type = MealGroupType.BREAKFAST,
                        mealItems = listOf(
                            MealItem(
                                quantity = 120.0f,
                                name = "apple",
                                units = FoodMeasurementUnit.GRAMS,
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
}
