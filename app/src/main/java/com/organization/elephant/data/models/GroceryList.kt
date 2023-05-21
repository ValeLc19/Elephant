package com.organization.elephant.data.models

data class GroceryList(
    val groceryItems: List<GroceryItem>,
    val dateInMillis: Long
){
    var formattedDate:String = "01/02/1200"
}
