package com.organization.elephant.mealplan.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.MealGroup
import com.organization.elephant.data.models.MealGroupType
import com.organization.elephant.data.models.MealItem
import com.organization.elephant.mealplannew.components.MealItemLine
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun MealPlanCard(
    mealGroup: MealGroup
) {
    var isOpen: Boolean by remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = Modifier
                .clickable {
                    isOpen = !isOpen
                }
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
                    modifier = Modifier.padding(start = 20.dp),
                    text = mealGroup.type.displayName,
                    fontSize = 20.sp
                )
            }
            Image(
                modifier = Modifier
                    .padding(end = 20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "icon arrow",
            )
        }
        Divider(
            modifier = Modifier
                .padding(end = 40.dp, start = 40.dp),
            thickness = 2.dp
        )
        if (isOpen) {
            Box(
                modifier = Modifier
                    .padding(start = 70.dp, end = 40.dp, bottom = 10.dp)
            ) {
                Column() {
                    mealGroup.mealItems.forEach {
                        MealItemLine(
                            showLine=false,
                            mealItem = it,
                            editingMealItem = false,
                            onUpdateMealItem = {}
                        )
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun MealPlanCardPreview() {
    ElephantTheme {
        MealPlanCard(
            mealGroup = MealGroup(
                type = MealGroupType.BREAKFAST,
                mealItems = listOf(
                    MealItem(
                        quantity = 120.0,
                        name = "apple",
                        units = FoodMeasurementUnit.GRAMS,
                    ),
                    MealItem(
                        quantity = 50.0,
                        name = "Milk",
                        units = FoodMeasurementUnit.MILLILITERS,
                    )
                )
            )
        )
    }
}
