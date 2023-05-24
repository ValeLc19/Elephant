package com.organization.elephant.ui.grocery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.organization.elephant.R
import com.organization.elephant.components.PrincipalTitle
import com.organization.elephant.ui.grocery.components.GroceryScreenCard
import com.organization.elephant.ui.theme.ElephantTheme

@Composable
fun GroceryScreen(
    navigateToGroceryListScreen:()-> Unit
) {
    Column() {
        PrincipalTitle(title = "Grocery"){
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            GroceryScreenCard(
                titleItem = "List Item",
                iconItemID = R.drawable.ic_grocery,
                onClick = {navigateToGroceryListScreen()}
            )
            GroceryScreenCard(
                titleItem = "Grocery Store",
                iconItemID = R.drawable.ic_grocery_store,
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun GroceryScreenPreview() {
    ElephantTheme {
        GroceryScreen(
            navigateToGroceryListScreen={}
        )
    }
}
