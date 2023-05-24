package com.organization.elephant.ui.grocerylistitem

import com.organization.elephant.data.models.GroceryItem
import com.organization.elephant.data.models.GroceryList

data class GroceryListState(
    val title: String,
    val groceryList: GroceryList,
    val newItem: GroceryItem? = null
)