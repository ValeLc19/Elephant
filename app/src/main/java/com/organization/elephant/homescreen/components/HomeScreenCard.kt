package com.organization.elephant.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.sp
import com.organization.elephant.ui.theme.ElephantTheme
import com.organization.elephant.R

@Composable
fun HomeScreenCard(
    title:String,
    iconID:Int,
    colorID:Int,
) {
    Column(
        modifier = Modifier
            .height(150.dp)
            .width(111.dp)
            .border(
                width = 5.dp,
                shape = RoundedCornerShape(10.dp),
                color = colorResource(id = colorID)
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .padding(top = 25.dp)
                .padding(horizontal = 9.dp),
            painter = painterResource(id = iconID),
            contentDescription = "food icon"
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(bottom = 10.dp),
            text = title,
            fontSize = 19.sp,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenCardPreview(){
    ElephantTheme {
        HomeScreenCard(
            title = "Title",
            iconID = R.drawable.ic_places,
            colorID = R.color.attribute_task
        )
    }
}