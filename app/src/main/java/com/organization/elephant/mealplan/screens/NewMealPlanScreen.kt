package com.organization.elephant.mealplan.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.data.models.*
import com.organization.elephant.mealplan.components.MealGroupCard
import com.organization.elephant.ui.theme.Background
import com.organization.elephant.ui.theme.ElephantTheme
import kotlin.math.round

@Composable
fun NewMealPlanScreen(
    mealPlan: MealPlan,
    onUpdateMealPlan: (newMealPlan: MealPlan) -> Unit
) {

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
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
                var isEditingNutritionalInfo by remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Nutritional Information",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        modifier = Modifier
                            .clickable {
                                isEditingNutritionalInfo = !isEditingNutritionalInfo
                            },
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "edit icon",
                    )
                }

                if (isEditingNutritionalInfo) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Carbs:",
                        )
                        TextField(
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            value = mealPlan.carbs.toString(),
                            onValueChange = { newValue ->

                                val cleanNewValue: String = newValue
                                    .filterNot { it == ',' }
                                    .filterNot { it == ' ' }
                                    .filterNot { it == '-' }
                                    .replaceFirst(".", "")


                                val newCarbs: Double = if (cleanNewValue.isBlank()) {
                                    0.0
                                } else {
                                    cleanNewValue.toDouble()
                                }

                                val updatedMealPlan = mealPlan.copy(carbs = newCarbs)
                                onUpdateMealPlan(updatedMealPlan)
                            },
                            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Fat:",
                        )
                        TextField(
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            value = mealPlan.fat.toString(),
                            onValueChange = { newValue ->

                                val cleanNewValue: String = newValue
                                    .filterNot { it == ',' }
                                    .filterNot { it == ' ' }
                                    .filterNot { it == '-' }
                                    .replaceFirst(".", "")


                                val newFats: Double = if (cleanNewValue.isBlank()) {
                                    0.0
                                } else {
                                    cleanNewValue.toDouble()
                                }

                                val updatedMealPlan = mealPlan.copy(fat = newFats)
                                onUpdateMealPlan(updatedMealPlan)
                            },
                            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Protein:",
                        )
                        TextField(
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            value = mealPlan.protein.toString(),
                            onValueChange = { newValue ->

                                val cleanNewValue: String = newValue
                                    .filterNot { it == ',' }
                                    .filterNot { it == ' ' }
                                    .filterNot { it == '-' }
                                    .replaceFirst(".", "")


                                val newProtein: Double = if (cleanNewValue.isBlank()) {
                                    0.0
                                } else {
                                    cleanNewValue.toDouble()
                                }

                                val updatedMealPlan = mealPlan.copy(protein = newProtein)
                                onUpdateMealPlan(updatedMealPlan)
                            },
                            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Calories:",
                        )
                        TextField(
                            modifier = Modifier
                                .padding(5.dp)
                                .width(90.dp),
                            value = mealPlan.calories.toString(),
                            onValueChange = { newValue ->

                                val cleanNewValue: String = newValue
                                    .filterNot { it == ',' }
                                    .filterNot { it == ' ' }
                                    .filterNot { it == '-' }
                                    .replaceFirst(".", "")


                                val newCalories: Double = if (cleanNewValue.isBlank()) {
                                    0.0
                                } else {
                                    cleanNewValue.toDouble()
                                }

                                val updatedMealPlan = mealPlan.copy(calories = newCalories)
                                onUpdateMealPlan(updatedMealPlan)
                            },
                            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }

                } else {
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
        }

        mealPlan.mealGroups.forEach { mealGroup ->
            MealGroupCard(mealGroup = mealGroup)
        }

        Button(
            modifier = Modifier
                .padding(end = 10.dp, top = 30.dp),
            onClick = {},
            shape = RoundedCornerShape(3.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.save_button)
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
            ),
            onUpdateMealPlan = {}
        )
    }
}
