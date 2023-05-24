package com.organization.elephant.ui.grocerybuyingitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.organization.elephant.data.models.GroceryStore
import com.organization.elephant.ui.grocerylistitem.components.GroceryItemCard
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun GroceryBuyingItemScreen(
    state: GroceryBuyingItemState,
    onMoveItemToCart:(groceryItem:GroceryItem)->Unit
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

        Text(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            text = "DATE",
            fontSize = 19.sp,
            textAlign = TextAlign.Center
        )

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .fillMaxWidth(),
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .size(20.dp),
                painter = painterResource(id = R.drawable.ic_not_found),
                contentDescription = "not found icon"
            )
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "Item not found/Not available",
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 5.dp, bottom = 5.dp),
            text = "Missing items",
            fontSize = 19.sp,
            textAlign = TextAlign.Start
        )
        state.itemsNotInCart.forEachIndexed { index, groceryItem ->
            GroceryItemCard(
                groceryItem = groceryItem,
                rightIconID = R.drawable.ic_not_found,
                leftIconID = R.drawable.ic_checked,
                deleteGroceryItem = {},
                addItemToCart = {}
            )
        }

        Divider(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .padding(top = 10.dp),
            thickness = 2.dp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Items in cart",
            fontSize = 19.sp,
            textAlign = TextAlign.Start
        )
        state.itemsInCart.forEachIndexed { index, groceryItem ->
            GroceryItemCard(
                groceryItem = groceryItem,
                rightIconID = R.drawable.ic_not_found,
                leftIconID = R.drawable.ic_check_green,
                deleteGroceryItem = {},
                addItemToCart = {}
            )
        }
        Divider(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .padding(top = 10.dp),
            thickness = 2.dp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Items not found",
            fontSize = 19.sp,
            textAlign = TextAlign.Start
        )
        state.itemsNotAvailable.forEachIndexed { index, groceryItem ->
            GroceryItemCard(
                groceryItem = groceryItem,
                rightIconID = R.drawable.ic_not_found,
                leftIconID = R.drawable.ic_not_found,
                deleteGroceryItem = {},
                addItemToCart = {}
            )
        }

    }


}

@Preview(showSystemUi = true)
@Composable
fun GroceryBuyingItemScreenPreview() {
    ElephantTheme {
        GroceryBuyingItemScreen(
            state = GroceryBuyingItemState(
                title = "List Items",
                groceryList = GroceryList(
                    dateInMillis = 364273591,
                    groceryItems = listOf(
                        GroceryItem(
                            quantity = 127788.0,
                            measurementUnit = FoodMeasurementUnit.CUPS,
                            itemName = "Milk",
                            isInCart = false,
                            isAvailable = true

                        ),
                        GroceryItem(
                            quantity = 12.0,
                            measurementUnit = FoodMeasurementUnit.CUPS,
                            itemName = "Potato",
                            isInCart = true,
                            isAvailable = true

                        ),
                        GroceryItem(
                            quantity = 1342.0,
                            measurementUnit = FoodMeasurementUnit.CUPS,
                            itemName = "chicken",
                            isInCart = false,
                            isAvailable = false,
                        )
                    )
                ),
                store = GroceryStore(
                    name = "Walmart",
                    type = "Supercenter",
                    address = "5700 Oakleaf Dr"
                ),
            ), onMoveItemToCart = {}
        )
    }
}