package com.organization.elephant.ui.grocerylistitem

import androidx.lifecycle.ViewModel
import com.organization.elephant.data.models.FoodMeasurementUnit
import com.organization.elephant.data.models.GroceryItem
import com.organization.elephant.data.models.GroceryList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class GroceryListViewModel : ViewModel() {

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
        updatedItem: GroceryItem?
    ) {
        state.update {
            it.copy(newItem = updatedItem)
        }
    }

    fun addNewItemToList() {
        state.update {
            val updatedGroceryListItems: MutableList<GroceryItem> =
                it.groceryList.groceryItems.toMutableList()
            it.newItem?.let { newItem -> updatedGroceryListItems.add(newItem) }

            val updatedGroceryList = it.groceryList.copy(
                groceryItems = updatedGroceryListItems
            )
            it.copy(
                groceryList = updatedGroceryList,
                newItem = GroceryItem(
                    quantity = 0.0,
                    measurementUnit = FoodMeasurementUnit.CUPS,
                    itemName = ""
                )
            )
        }
    }

    fun deleteItemOnList(
        indexToRemove:Int
    ){
        state.update {
            val updatedItems = it.groceryList.groceryItems.toMutableList()
            updatedItems.removeAt(indexToRemove)

           val updatedGroceryList = it.groceryList.copy(groceryItems = updatedItems)
            it.copy(groceryList = updatedGroceryList)
        }
    }
}