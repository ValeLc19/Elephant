package com.organization.elephant.mealplan.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.MealItem

@Composable
fun MealItemLine(
    mealItem: MealItem,
    editingMealItem: Boolean

) {
    var isMenuExpanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    Column {
        if (editingMealItem) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            )
            {
                TextField(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(height = 30.dp, width = 50.dp),
                    value = "${mealItem.quantity}",
                    onValueChange = {}
                )
                MealItemDropDownMenu(
                    modifier = Modifier
                        .padding(10.dp),
                    isExpanded = isMenuExpanded,
                    items = FoodMeasurementUnit.values().map { it.abbreviation },
                    onSelectionMade = {selectedIndex = it},
                    onToggleExpansion = { isMenuExpanded = !isMenuExpanded },
                    selectedItemIndex =selectedIndex
                )
                TextField(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(height = 30.dp, width = 50.dp),
                    value = "${mealItem.name}",
                    onValueChange = {}
                )

            }

        } else {
            Text(text = "${mealItem.quantity} ${mealItem.units.abbreviation} ${mealItem.name}")
        }

        Divider(
            modifier = Modifier
                .padding(end = 75.dp, top = 1.dp, bottom = 4.dp),
            thickness = 2.dp
        )
    }
}

@Preview
@Composable
fun MealItemLinePreview() {
    MealItemLine(
        mealItem = MealItem(
            name = "banana",
            quantity = 120.0f,
            units = FoodMeasurementUnit.GRAMS
        ),
        editingMealItem = true
    )
}