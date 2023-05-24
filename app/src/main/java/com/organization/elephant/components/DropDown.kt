package com.organization.elephant.components

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.R
import com.organization.elephant.data.models.FoodMeasurementUnit

@Composable
fun DropDown(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    items: List<String>,
    labelText: String = "",
    validationMessageText: String = "",
    validationMessageColor: Color = Color.Red,
    onSelectionMade: (Int) -> Unit,
    onToggleExpansion: () -> Unit,
    selectedItemIndex: Int,
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
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth(),
                text = labelText,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = font,
            )
        }

        Row(
            modifier = Modifier
                .height(45.dp)
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
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = items[selectedItemIndex],
                    color = Color.Black,
                    fontFamily = font,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }

            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(25)
                    )
                    .clickable {
                        onToggleExpansion()
                    },
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Expand drop down menu",
            )
        }

        DropdownMenu(
            modifier = Modifier
                .background(
                    colorResource(id = R.color.background_meal_plan).copy(alpha = 0.12f)
                )
                .heightIn(0.dp, 200.dp),
            expanded = isExpanded,
            onDismissRequest = {
                onToggleExpansion()
            },
        ) {
            items.mapIndexed { index, item ->
                val backgroundColor = if (index == selectedItemIndex) {
                    colorResource(id = R.color.background_meal_plan)
                } else {
                    colorResource(id = R.color.background_meal_plan).copy(alpha = 0.12f)
                }

                Text(
                    modifier = Modifier
                        .clickable {
                            onSelectionMade(
                                index
                            )
                        }
                        .fillMaxWidth()
                        .background(backgroundColor)
                        .padding(10.dp),
                    text = item,
                    fontFamily = font,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
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

        DropDown(
            modifier = Modifier.width(240.dp),
            isExpanded = isMenuExpanded,
            items = FoodMeasurementUnit.values().map { it.abbreviation },
            labelText = "",
            validationMessageText = "",
            validationMessageColor = Color.Red,
            onSelectionMade = {
                selectedIndex = it
            },
            onToggleExpansion = {
                isMenuExpanded = !isMenuExpanded
            },
            selectedItemIndex = selectedIndex,
        )
    }
}
