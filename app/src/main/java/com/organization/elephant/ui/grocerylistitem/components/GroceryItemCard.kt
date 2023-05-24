package com.organization.elephant.ui.grocerylistitem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.organization.elephant.R
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.GroceryItem
import com.organization.elephant.ui.mealplan.components.SquareIcon
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun GroceryItemCard(
    groceryItem: GroceryItem,
    leftIconID: Int?,
    rightIconID: Int,
    deleteGroceryItem: () -> Unit,
    addItemToCart:()-> Unit
) {
    val font = FontFamily(
        Font(R.font.font_comfortaa),
    )
    Column {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                if (leftIconID == null) {
                    SquareIcon()
                } else {
                    Image(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {
                                addItemToCart()
                            }
                            .size(20.dp),
                        painter = painterResource(id = leftIconID),
                        contentDescription = "check icon",
                    )
                }

                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "${groceryItem.quantity} ${groceryItem.measurementUnit.abbreviation} ${groceryItem.itemName}"
                )
            }

            if(!groceryItem.isInCart && groceryItem.isAvailable){
                Image(
                    modifier = Modifier
                        .clickable {
                            deleteGroceryItem()
                        }
                        .padding(end = 20.dp)
                        .size(20.dp),
                    painter = painterResource(id = rightIconID),
                    contentDescription = "delete item",
                )
            }

        }
    }
}

@Preview
@Composable
fun GroceryItemCardPreview() {
    ElephantTheme {
        GroceryItemCard(
            groceryItem = GroceryItem(
                quantity = 12.0,
                measurementUnit = FoodMeasurementUnit.CUPS,
                itemName = "Rice",
            ),
            addItemToCart = {},
            deleteGroceryItem = {},
            rightIconID = R.drawable.ic_delete,
            leftIconID = null
        )
    }
}