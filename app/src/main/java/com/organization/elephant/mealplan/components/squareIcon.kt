package com.organization.elephant.mealplan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.organization.elephant.R

@Composable
fun squareIcon(){
    Box(
        modifier = Modifier
            .padding(start = 20.dp)
            .size(8.dp)
            .background(color = colorResource(id = R.color.attribute_food))
    )
}

