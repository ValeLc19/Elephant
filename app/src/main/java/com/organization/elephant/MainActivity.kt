package com.organization.elephant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElephantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ElephantTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "Good Morning",
                fontSize = 30.sp,
            )

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

        Divider(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .padding(top = 10.dp),
            thickness = 2.dp
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(bottom = 45.dp, top = 30.dp)
                .fillMaxWidth(),

        ) {
            HomeScreenCard(title = "Food", iconID = R.drawable.ic_food, colorID = R.color.attribute_food )
            HomeScreenCard(title = "Task", iconID = R.drawable.ic_task, colorID = R.color.attribute_task)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(bottom = 45.dp)
                .fillMaxWidth()
        ) {
            HomeScreenCard(title = "Clean", iconID = R.drawable.ic_clean, colorID = R.color.attribute_clean)
            HomeScreenCard(title = "Fitness", iconID = R.drawable.ic_fitness, colorID = R.color.attribute_fitness)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(bottom = 45.dp)
                .fillMaxWidth()
        ) {
            HomeScreenCard(title = "Finances", iconID = R.drawable.ic_finances, colorID = R.color.attribute_finances )
            HomeScreenCard(title = "Places", iconID = R.drawable.ic_places, colorID = R.color.attribute_places)
        }


    }


}


@Composable
fun HomeScreenCard(
    title:String,
    iconID:Int,
    colorID:Int,
){
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
            modifier=Modifier
                .size(100.dp)
                .padding(top = 25.dp)
                .padding(horizontal = 9.dp),
            painter = painterResource(id = iconID),
            contentDescription = "food icon"
        )
        Text(
            modifier= Modifier
                .padding(horizontal = 10.dp)
                .padding(bottom = 10.dp),
            text = title,
            fontSize = 19.sp,
        )
    }

}