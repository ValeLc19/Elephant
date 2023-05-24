package com.organization.elephant.ui.mealplan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.organization.elephant.R

@Composable
fun SquareIcon(){
    Box(
        modifier = Modifier
            .padding(start = 20.dp)
            .size(8.dp)
            .background(color = colorResource(id = R.color.attribute_food))
    )
}

