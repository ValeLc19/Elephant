package com.organization.elephant.ui.mealplannew

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.data.models.*
import com.organization.elephant.ui.mealplannew.components.MealGroupCard
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun NewMealPlanScreen(
    state: NewMealPlanState,
    onUpdateMealPlan: (newMealPlan: MealPlan) -> Unit
) {

    val font = FontFamily(
        Font(R.font.font_comfortaa),
    )

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrincipalTitle(
            title = state.title,
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
                        text = state.mealPlan.formattedStartDate,
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
                        text = state.mealPlan.formattedEndDate,
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
                            textStyle = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = font
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(2.dp),
                            value = state.mealPlan.carbs.toString(),
                            onValueChange = { newValue ->

                                val cleanInput = cleanDoubleTextFieldInput(
                                    newValueToClean = newValue,
                                    oldValue = state.mealPlan.carbs.toString()
                                )

                                val updatedMealPlan = state.mealPlan.copy(carbs = cleanInput)
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
                            textStyle = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = font
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(2.dp),
                            value = state.mealPlan.fat.toString(),
                            onValueChange = { newValue ->

                                val cleanInput = cleanDoubleTextFieldInput(
                                    newValueToClean = newValue,
                                    oldValue = state.mealPlan.fat.toString()
                                )

                                val updatedMealPlan = state.mealPlan.copy(fat = cleanInput)
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
                            textStyle = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = font
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(2.dp),
                            value = state.mealPlan.protein.toString(),
                            onValueChange = { newValue ->

                                val cleanInput = cleanDoubleTextFieldInput(
                                    newValueToClean = newValue,
                                    oldValue = state.mealPlan.protein.toString()
                                )

                                val updatedMealPlan = state.mealPlan.copy(protein = cleanInput)
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
                            textStyle = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = font
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(2.dp),
                            value = state.mealPlan.calories.toString(),
                            onValueChange = { newValue ->

                                val cleanInput = cleanDoubleTextFieldInput(
                                    newValueToClean = newValue,
                                    oldValue = state.mealPlan.calories.toString()
                                )

                                val updatedMealPlan = state.mealPlan.copy(calories = cleanInput)
                                onUpdateMealPlan(updatedMealPlan)
                            },
                            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }

                } else {
                    Text(
                        text = "Carbs: ${state.mealPlan.carbs}",
                    )
                    Text(
                        text = "Fat: ${state.mealPlan.fat}",
                    )
                    Text(
                        text = "Protein: ${state.mealPlan.protein}",
                    )
                    Text(
                        text = "Calories: ${state.mealPlan.calories}",
                    )

                }
            }
        }

        state.mealPlan.mealGroups.forEachIndexed { index, mealGroup ->
            MealGroupCard(
                mealGroup = mealGroup,
                onUpdateMealGroup = { updatedMealGroup ->
                    val updatedMealGroupMutableList: MutableList<MealGroup> = state.mealPlan.mealGroups.toMutableList()
                    updatedMealGroupMutableList[index] = updatedMealGroup

                    val updateMealPlan = state.mealPlan.copy(mealGroups = updatedMealGroupMutableList)
                    onUpdateMealPlan(updateMealPlan)
                }
            )
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
            Text(
                text = "Save",
                fontFamily = font
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NewMealPlanScreenPreview() {
    ElephantTheme {
        NewMealPlanScreen(
            state = NewMealPlanState(
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
                                    quantity = 120.0,
                                    name = "apple",
                                    units = FoodMeasurementUnit.GRAMS,
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
                title = "Add New Meal Plan"
            ),
            onUpdateMealPlan = {}
        )
    }
}

fun cleanDoubleTextFieldInput(
    newValueToClean: String,
    oldValue: String
): Double {

    //Arregla caso donde usuario trate de agregar segundo punto
    if (newValueToClean.count { it == '.' } > 1) {
        return oldValue.toDouble()
    }

    val cleanNewValue: String = newValueToClean
        .filterNot { it == ',' }
        .filterNot { it == ' ' }
        .filterNot { it == '-' }


    val cleanValue: Double = if (cleanNewValue.isBlank()) {
        0.0
    } else {
        cleanNewValue.toDouble()
    }

    return cleanValue
}