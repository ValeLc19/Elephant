package com.organization.elephant.data.models

import kotlinx.serialization.Serializable

@Serializable
data class MealPlan(
    val id:Int? = null,
    val startDateInMillis: Long,
    val endDateInMillis: Long,
    val carbs: Double,
    val fat: Double,
    val protein: Double,
    val calories: Double,
    val mealGroups:List<MealGroup>
){
    var formattedStartDate:String = "01/02/1200"
    var formattedEndDate: String = "00/00/2023"
}

//Representa cada grupo del meal (breakfast etc)
@Serializable
data class MealGroup(
    val id:Int? = null,
    val type:MealGroupType,
    val mealItems:List<MealItem>
)

@Serializable
enum class MealGroupType(val displayName: String){
    BREAKFAST(displayName = "Breakfast"),
    SNACK(displayName = "Snack"),
    LUNCH(displayName = "Lunch"),
    DINNER(displayName = "Dinner"),
}

//Representa las lineas a escribir la informacion
@Serializable
data class MealItem(
    val id:Int? = null,
    val quantity: Double,
    val name: String,
    val units: FoodMeasurementUnit,
)

@Serializable
enum class FoodMeasurementUnit(val abbreviation: String) {
    BOTTLE(abbreviation = "btl"),
    BOX(abbreviation = "box"),
    DASH(abbreviation = "dash"),
    DOZEN(abbreviation = "doz"),
    CUPS(abbreviation = "cup"),
    GALLON(abbreviation = "gal"),
    GRAMS(abbreviation = "gr"),
    MILLILITERS(abbreviation = "ml"),
    OUNCES(abbreviation = "oz"),
    PACKAGE(abbreviation = "pkg"),
    PIECE(abbreviation = "pc"),
    PINCH(abbreviation = "pinch"),
    POUND(abbreviation = "lb"),
    STICK(abbreviation = "stk"),
    TEASPOON(abbreviation = "tsp"),
    TABLESPOON(abbreviation = "tbsp"),
}
