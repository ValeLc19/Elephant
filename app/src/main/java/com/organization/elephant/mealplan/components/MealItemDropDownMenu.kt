package com.organization.elephant.mealplan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.data.models.FoodMeasurementUnit


@Composable
fun MealItemDropDownMenu(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    items: List<String>,
    labelText: String = "",
    validationMessageText: String = "",
    validationMessageColor: Color = Color.Red,
    onSelectionMade: (Int) -> Unit,
    onToggleExpansion: () -> Unit,
    selectedItemIndex: Int,
    height: Dp = 45.dp
) {

    val font = FontFamily(
        Font(R.font.font_comfortaa),
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        if (labelText.isNotBlank()) {
            Text(
                labelText,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = font,
            )
        }

        Row(
            modifier = Modifier
                .size(width = 60.dp, height = 33.dp)
                .height(height)
                .border(
                    1.dp,
                    colorResource(id = R.color.background_meal_plan).copy(alpha = 0.12f),
                    shape = RoundedCornerShape(25)
                ),
            horizontalArrangement = if (selectedItemIndex == -1) Arrangement.End else Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (selectedItemIndex != -1) {
                Text(
                    text = items[selectedItemIndex],
                    color = Color.Black,
                    fontFamily = font,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Expand drop down menu",
                //tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(25)
                    )
                    .clickable { onToggleExpansion() })
        }

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { onToggleExpansion() },
            modifier = Modifier
                .background(colorResource(id = R.color.background_meal_plan).copy(alpha = 0.12f))
                .heightIn(0.dp, 200.dp)
                .fillMaxWidth(.15f)
        ) {
            items.mapIndexed { index, item ->
                val backgroundColor =
                    if (index == selectedItemIndex) colorResource(id = R.color.background_meal_plan)
                    else colorResource(id = R.color.background_meal_plan).copy(alpha = 0.12f)

                Text(
                    text = item,
                    fontFamily =font,
                    color = Color.Black,
                    modifier = Modifier
                        .clickable {
                            onSelectionMade(
                                index
                            )
                        }
                        .fillMaxWidth()
                        .background(backgroundColor)
                        .padding(10.dp))
            }
        }

        if (validationMessageText.isNotBlank()) {
            Text(
                text = validationMessageText,
                color = validationMessageColor,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                fontFamily = font,
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun MealItemDropDownMenuPreview() {
    var isMenuExpanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        MealItemDropDownMenu(
            modifier = Modifier.width(240.dp),
            isExpanded = isMenuExpanded,
            items = FoodMeasurementUnit.values().map { it.abbreviation },
            labelText = "",
            validationMessageText = "",
            validationMessageColor = Color.Red,
            onSelectionMade = {
                selectedIndex = it
            },
            onToggleExpansion = { isMenuExpanded = !isMenuExpanded },
            selectedItemIndex = selectedIndex,
            height = 50.dp
        )
    }
}
