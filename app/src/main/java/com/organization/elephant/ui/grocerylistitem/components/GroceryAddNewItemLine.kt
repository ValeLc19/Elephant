package com.organization.elephant.ui.grocerylistitem.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
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
import com.organization.elephant.data.models.GroceryItem
import com.organization.elephant.components.DropDown
import com.organization.elephant.ui.mealplannew.cleanDoubleTextFieldInput
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun GroceryAddNewItemLine(
    groceryItem: GroceryItem,
    onUpdateGroceryItem: (updatedGroceryItem: GroceryItem?) -> Unit,
    addGroceryItem: ()->Unit,
) {
    var isMenuExpanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    val font = FontFamily(
        Font(R.font.font_comfortaa),
    )

    Column(
        modifier = Modifier.padding(top = 25.dp)
    ){
        Row(
            modifier=Modifier
                .padding(start = 20.dp, end = 20.dp),
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
                value = groceryItem.quantity.toString(),
                onValueChange = {
                    val newValue = cleanDoubleTextFieldInput(
                        oldValue = groceryItem.quantity.toString(),
                        newValueToClean = it
                    )
                    onUpdateGroceryItem(groceryItem.copy(quantity = newValue))
                },
            )

            DropDown(
                modifier = Modifier
                    .padding(5.dp),
                isExpanded = isMenuExpanded,
                items = FoodMeasurementUnit.values().map { it.abbreviation },
                onSelectionMade = {
                    selectedIndex = it
                    val updatedGroceryItem: GroceryItem =
                        groceryItem.copy(measurementUnit = FoodMeasurementUnit.values()[selectedIndex])
                    onUpdateGroceryItem(updatedGroceryItem)
                },
                onToggleExpansion = {
                    isMenuExpanded = !isMenuExpanded
                    onUpdateGroceryItem(
                        groceryItem.copy(
                            measurementUnit = FoodMeasurementUnit.values()[selectedIndex]
                        )
                    )
                },
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
                value = groceryItem.itemName,
                onValueChange = {
                    onUpdateGroceryItem(groceryItem.copy(itemName = it))
                },
            )
        }
        Row(
            modifier=Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ){
            OutlinedButton(
                modifier = Modifier
                    .height(40.dp)
                    .width(80.dp),
                onClick = {
                    addGroceryItem()
                },
                shape = RoundedCornerShape(3.dp),
            ) {
                Text(
                    text = "Add",
                    fontFamily = font
                )
            }

            OutlinedButton(
                modifier = Modifier
                    .height(40.dp)
                    .width(80.dp),
                onClick = {
                    onUpdateGroceryItem(null)
                },
                shape = RoundedCornerShape(3.dp),
            ) {
                Text(
                    text = "Done",
                    fontFamily = font
                )
            }
        }
    }
}

@Preview
@Composable
fun GroceryAddNewItemLinePreview() {
    ElephantTheme {
        GroceryAddNewItemLine(
            groceryItem = GroceryItem(
                quantity = 12.0,
                measurementUnit = FoodMeasurementUnit.CUPS,
                itemName = "Rice"
            ),
            onUpdateGroceryItem = {},
            addGroceryItem = {},
        )
    }
}