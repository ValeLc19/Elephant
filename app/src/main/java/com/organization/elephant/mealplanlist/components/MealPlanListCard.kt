package com.organization.elephant.mealplanlist.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun MealPlanListCard(
    starDate: String,
    endDate: String,
    calories: Double,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .height(93.dp)
            .fillMaxWidth()
            .border(
                width = 5.dp,
                shape = RoundedCornerShape(30.dp),
                color = colorResource(id = R.color.attribute_food)
            )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, top = 10.dp),
            text = "$starDate-$endDate",
            fontWeight = Bold,
            fontSize = 25.sp,
        )
        Text(
            modifier = Modifier.padding(start = 30.dp, bottom = 5.dp),
            text = "Calories: ${calories}",
            fontSize = 18.sp,
        )
    }
}


@Preview()
@Composable
fun MealPlanListCardPreview() {
    ElephantTheme {
        MealPlanListCard(
            starDate = "12 Nov",
            endDate = "20 Nov",
            calories = 1200.0,
            onClick = {}
        )
    }
}
