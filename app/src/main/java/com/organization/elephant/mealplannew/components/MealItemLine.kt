package com.organization.elephant.mealplannew.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.MealItem
import com.organization.elephant.mealplannew.cleanDoubleTextFieldInput

@Composable
fun MealItemLine(
    mealItem: MealItem,
    editingMealItem: Boolean,
    showLine:Boolean,
    onUpdateMealItem: (updatedMealItem: MealItem) -> Unit
) {
    var isMenuExpanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    val font = FontFamily(
        Font(R.font.font_comfortaa),
    )

    Column {
        if (editingMealItem) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextField(
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = font
                    ),
                    modifier = Modifier
                        .padding(5.dp)
                        .size(height = 60.dp, width = 100.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    value = mealItem.quantity.toString(),
                    onValueChange = { newValue ->
                        val cleanInput: Double = cleanDoubleTextFieldInput(
                            newValueToClean = newValue,
                            oldValue = mealItem.quantity.toString()
                        )
                        val updatedMealPlan: MealItem = mealItem.copy(quantity = cleanInput)
                        onUpdateMealItem(updatedMealPlan)
                    },
                )

                MealItemDropDownMenu(
                    modifier = Modifier
                        .padding(5.dp),
                    isExpanded = isMenuExpanded,
                    items = FoodMeasurementUnit.values().map { it.abbreviation },
                    onSelectionMade = {
                        selectedIndex = it
                        val updatedMealItem: MealItem = mealItem.copy(units = FoodMeasurementUnit.values()[selectedIndex] )
                        onUpdateMealItem(updatedMealItem)
                    },
                    onToggleExpansion = { isMenuExpanded = !isMenuExpanded },
                    selectedItemIndex = selectedIndex
                )

                TextField(
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = font
                    ),
                    modifier = Modifier
                        .padding(5.dp)
                        .size(height = 60.dp, width = 200.dp),
                    value = "${mealItem.name}",
                    onValueChange = { newText ->
                        val updatedMealItem: MealItem = mealItem.copy(name = newText)
                        onUpdateMealItem(updatedMealItem)
                    }
                )
            }
        } else {
            Text(text = "${mealItem.quantity} ${mealItem.units.abbreviation} ${mealItem.name}")
        }

        if(showLine){
            Divider(
                modifier = Modifier
                    .padding(end = 5.dp, top = 0.5.dp, bottom = 4.dp),
                thickness = 2.dp
            )
        }

    }
}

@Preview
@Composable
fun MealItemLinePreview() {
    MealItemLine(
        showLine=true,
        mealItem = MealItem(
            name = "banana",
            quantity = 120.0,
            units = FoodMeasurementUnit.GRAMS
        ),
        editingMealItem = true,
        onUpdateMealItem = {}
    )
}