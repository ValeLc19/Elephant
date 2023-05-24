package com.organization.elephant.ui.grocerylistitem

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.GroceryItem
import com.organization.elephant.data.models.GroceryList
import com.organization.elephant.ui.grocerylistitem.components.GroceryAddNewItemLine
import com.organization.elephant.ui.grocerylistitem.components.GroceryItemCard
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun GroceryListScreen(
    state: GroceryListState,
    onUpdateNewItem: (updatedNewItem: GroceryItem?) -> Unit,
    addNewItemToList: () -> Unit,
    deleteItemToList: (indexToRemove: Int) -> Unit
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val font = FontFamily(
            Font(R.font.font_comfortaa),
        )

        PrincipalTitle(
            title = state.title,
            icon = {}
        )

        Text(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            text = state.groceryList.formattedDate,
            fontSize = 19.sp,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Missing items",
            fontSize = 19.sp,
            textAlign = TextAlign.Start
        )

        state.groceryList.groceryItems.forEachIndexed { index, groceryItem ->
            GroceryItemCard(
                groceryItem = groceryItem,
                deleteGroceryItem = {
                    deleteItemToList(index)
                },
                rightIconID = R.drawable.ic_delete,
                leftIconID = null,
                addItemToCart = {}
            )
        }

        if (state.newItem == null) {
            OutlinedButton(
                modifier = Modifier
                    .height(70.dp)
                    .width(150.dp)
                    .padding(end = 10.dp, top = 30.dp),
                onClick = {
                    onUpdateNewItem(
                        GroceryItem(
                            quantity = 0.0,
                            measurementUnit = FoodMeasurementUnit.CUPS,
                            itemName = ""
                        )
                    )
                },
                shape = RoundedCornerShape(3.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "add icon"
                )
                Text(
                    text = "New Item",
                    fontFamily = font
                )
            }
        }

        Divider(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .padding(top = 10.dp),
            thickness = 2.dp
        )

        if (state.newItem != null) {
            GroceryAddNewItemLine(
                groceryItem = state.newItem,
                onUpdateGroceryItem = {
                    onUpdateNewItem(it)
                },
                addGroceryItem = {
                    addNewItemToList()
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GroceryListScreenPreview() {
    ElephantTheme {
        GroceryListScreen(
            state = GroceryListState(
                title = "Grocery List",
                groceryList = GroceryList(
                    dateInMillis = 364273591,
                    groceryItems = listOf(
                        GroceryItem(
                            quantity = 12.0,
                            measurementUnit = FoodMeasurementUnit.CUPS,
                            itemName = "Rice"
                        ),
                        GroceryItem(
                            quantity = 1342.0,
                            measurementUnit = FoodMeasurementUnit.CUPS,
                            itemName = "chicken"
                        )
                    )
                )
            ),
            onUpdateNewItem = {},
            addNewItemToList = {},
            deleteItemToList = {}
        )
    }
}

