package com.organization.elephant.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.home.components.HomeScreenCard
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun HomeScreen(
    navigateToFood: () -> Unit
) {
    Column {
        PrincipalTitle(
            title = "Good Morning",
            icon = {
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.weather_icon),
                            shape = RoundedCornerShape(100)
                        )
                        .padding(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_raining),
                        contentDescription = "weather icon"
                    )
                }
            }
        )


        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(bottom = 45.dp, top = 30.dp)
                .fillMaxWidth(),

            ) {
            HomeScreenCard(
                title = "Food",
                iconID = R.drawable.ic_food,
                colorID = R.color.attribute_food,
                onClick = { navigateToFood() })
            HomeScreenCard(
                title = "Task",
                iconID = R.drawable.ic_task,
                colorID = R.color.attribute_task,
                onClick = {})
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(bottom = 45.dp)
                .fillMaxWidth()
        ) {
            HomeScreenCard(
                title = "Clean",
                iconID = R.drawable.ic_clean,
                colorID = R.color.attribute_clean,
                onClick = {})
            HomeScreenCard(
                title = "Fitness",
                iconID = R.drawable.ic_fitness,
                colorID = R.color.attribute_fitness,
                onClick = {})
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(bottom = 45.dp)
                .fillMaxWidth()
        ) {
            HomeScreenCard(
                title = "Finances",
                iconID = R.drawable.ic_finances,
                colorID = R.color.attribute_finances,
                onClick = {})
            HomeScreenCard(
                title = "Places",
                iconID = R.drawable.ic_places,
                colorID = R.color.attribute_places,
                onClick = {})
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    ElephantTheme {
        HomeScreen(
            navigateToFood = {}
        )
    }
}
