package com.organization.elephant.grocerylistitem.components

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
import com.organization.elephant.mealplan.components.squareIcon
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun GroceryItemCard(
    groceryItem: GroceryItem

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
                squareIcon()
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "${groceryItem.quantity} ${groceryItem.measurementUnit.abbreviation} ${groceryItem.itemName}"
                )
            }
            Image(
                modifier = Modifier
                    .clickable {}
                    .padding(end = 20.dp),
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "delete item",
            )
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
                itemName = "Rice"
            )
        )
    }
}