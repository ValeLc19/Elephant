package com.organization.elephant.grocerylistitem

import androidx.lifecycle.ViewModel
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.GroceryItem
import com.organization.elephant.data.models.GroceryList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class GroceryListViewModel() : ViewModel() {

    var state = MutableStateFlow<GroceryListState>(
        GroceryListState(
            title = "Grocery List",
            groceryList = GroceryList(
                dateInMillis = 364273591,
                groceryItems = listOf(
                    GroceryItem(
                        quantity = 12.0,
                        measurementUnit = FoodMeasurementUnit.CUPS,
                        itemName = "Rice"
                    )
                )
            )
        )
    )

    fun updateNewItem(
        updatedItem:GroceryItem
    ){
        println("okkk r")
        state.update {
            it.copy(newItem = updatedItem)
        }
    }
}