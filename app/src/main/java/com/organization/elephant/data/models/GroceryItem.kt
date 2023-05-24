package com.organization.elephant.data.models

data class GroceryItem(
    val quantity: Double,
    val measurementUnit: FoodMeasurementUnit,
    val itemName: String,
    val isInCart: Boolean = true,
    val isAvailable:Boolean = true
)