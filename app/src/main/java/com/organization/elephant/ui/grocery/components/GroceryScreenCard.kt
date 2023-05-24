package com.organization.elephant.ui.grocery.components

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun GroceryScreenCard(
titleItem: String,
iconItemID: Int,
onClick:()->Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onClick() }
            .height(262.dp)
            .width(328.dp)
            .border(
                width = 5.dp,
                shape = RoundedCornerShape(10.dp),
                color = colorResource(id = R.color.attribute_food)
            ),
    ) {
        Image(
            modifier = Modifier
                .size(100.dp),
            painter = painterResource(id = iconItemID),
            contentDescription = "list icon"
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = titleItem,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun FoodScreenCardPreview() {
    ElephantTheme {
        GroceryScreenCard(
            titleItem = "List Items",
            iconItemID = R.drawable.ic_grocery,
            onClick = {}
        )
    }
}