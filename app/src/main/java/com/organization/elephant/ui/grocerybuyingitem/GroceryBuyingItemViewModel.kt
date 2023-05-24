package com.organization.elephant.ui.grocerybuyingitem

import androidx.lifecycle.ViewModel
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.GroceryItem
import com.organization.elephant.data.models.GroceryList
import com.organization.elephant.data.models.GroceryStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class GroceryBuyingItemViewModel() : ViewModel() {

    var state = MutableStateFlow<GroceryBuyingItemState>(
        GroceryBuyingItemState(
            title = "List Items",
            groceryList = GroceryList(
                dateInMillis = 364273591,
                groceryItems = listOf(
                    GroceryItem(
                        quantity = 12.0,
                        measurementUnit = FoodMeasurementUnit.CUPS,
                        itemName = "Rice"
                    ),
                    GroceryItem(
                        quantity = 1342.0,
                        measurementUnit = FoodMeasurementUnit.CUPS,
                        itemName = "chicken"
                    )
                )
            ),
            store = GroceryStore(
                name = "Walmart",
                type = "Supercenter",
                address = "5700 Oakleaf Dr"
            ),
        )
    )

    fun addItemToCart(
        groceryItem: GroceryItem
    ){
        state.update {
            val updatedItems = it.groceryList.groceryItems.toMutableList()
            updatedItems.remove(groceryItem)
            updatedItems.add(groceryItem.copy(isInCart = true, isAvailable = true))

            val updatedGroceryList = it.groceryList.copy(groceryItems = updatedItems)

            it.copy(groceryList = updatedGroceryList)
        }
    }
}
