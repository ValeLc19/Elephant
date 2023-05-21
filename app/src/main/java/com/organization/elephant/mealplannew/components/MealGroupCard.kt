package com.organization.elephant.mealplannew.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.MealGroup
import com.organization.elephant.data.models.MealGroupType
import com.organization.elephant.data.models.MealItem

@Composable
fun MealGroupCard(
    mealGroup: MealGroup,
    onUpdateMealGroup: (mealGroup: MealGroup) -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var isMealGroupExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .clickable { isMealGroupExpanded = !isMealGroupExpanded }
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 5.dp)
            .background(colorResource(id = R.color.background_meal_plan).copy(alpha = 0.12f))
    ) {
        Column(
            modifier = Modifier.padding(start = 10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = mealGroup.type.displayName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    modifier = Modifier.clickable {
                        isEditing = !isEditing
                        isMealGroupExpanded = true
                    },
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "edit icon",
                )
            }
            if (isMealGroupExpanded) {
                mealGroup.mealItems.forEachIndexed { index, mealItem ->
                    MealItemLine(
                        showLine=true,
                        mealItem = mealItem,
                        editingMealItem = isEditing,
                        onUpdateMealItem = { updatedMealItem ->

                            val updatedMutableList: MutableList<MealItem> = mealGroup.mealItems.toMutableList()
                            updatedMutableList[index] = updatedMealItem

                            val updatedMealGroup: MealGroup =
                                mealGroup.copy(mealItems = updatedMutableList)
                            onUpdateMealGroup(updatedMealGroup)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MealGroupCardPreview() {
    MealGroupCard(
        mealGroup = MealGroup(
            type = MealGroupType.DINNER,
            mealItems = listOf(
                MealItem(
                    name = "fresas",
                    quantity = 10.0,
                    units = FoodMeasurementUnit.GRAMS
                )
            )
        ),
        onUpdateMealGroup = {},
    )
}