package com.organization.elephant.food

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun FoodScreen() {
    Column() {
        PrincipalTitle(
            title = "Food",
            icon = {}
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun FoodScreenPreview() {
    ElephantTheme {
        FoodScreen()
    }
}