package com.organization.elephant.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.organization.elephant.R
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun FoodScreenCard(
    titleItem: String,
    iconItemID: Int,
    onClick:()->Unit
) {
    Row(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
            .clickable { onClick() }
            .border(
                width = 5.dp,
                shape = RoundedCornerShape(10.dp),
                color = colorResource(id = R.color.attribute_food)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.padding(start = 10.dp),
            painter = painterResource(id = iconItemID),
            contentDescription = "meal plan icon"
        )
        Text(
            modifier = Modifier.padding(start = 30.dp),
            text = titleItem,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FoodScreenCardPreview() {
    ElephantTheme() {
        FoodScreenCard(
            titleItem = "Item Name",
            iconItemID = R.drawable.ic_food,
            onClick = {}
        )
    }
}
