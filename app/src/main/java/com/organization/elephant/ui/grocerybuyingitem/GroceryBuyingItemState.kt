package com.organization.elephant.ui.grocerybuyingitem

import com.organization.elephant.data.models.GroceryItem
import com.organization.elephant.data.models.GroceryList
import com.organization.elephant.data.models.GroceryStore

data class GroceryBuyingItemState(
    val title: String,
    val groceryList: GroceryList,
    val store: GroceryStore,
) {
    val itemsNotInCart: List<GroceryItem>
        get() {
            return groceryList.groceryItems.filter {
                !it.isInCart && it.isAvailable
            }
        }

    val itemsInCart: List<GroceryItem>
        get() {
            return groceryList.groceryItems.filter {
                it.isInCart && it.isAvailable
            }
        }

    val itemsNotAvailable: List<GroceryItem>
        get() {
            return groceryList.groceryItems.filter {
                !it.isAvailable && !it.isInCart
            }
        }
}