package com.organization.elephant.mealplannew

import androidx.lifecycle.ViewModel
import com.organization.elephant.data.models.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class NewMealPlanViewModel() : ViewModel() {

    var state = MutableStateFlow<NewMealPlanState>(
        NewMealPlanState(
            mealPlan = MealPlan(
                startDateInMillis = 1683244800000,
                endDateInMillis = 1685923200000,
                carbs = 160.0,
                fat = 30.0,
                protein = 160.0,
                calories = 1612.0,
                mealGroups = listOf(
                    MealGroup(
                        type = MealGroupType.BREAKFAST,
                        mealItems = listOf(
                            MealItem(
                                quantity = 120.0,
                                name = "apple",
                                units = FoodMeasurementUnit.GRAMS,
                            ),
                            MealItem(
                                quantity = 50.0,
                                name = "Milk",
                                units = FoodMeasurementUnit.MILLILITERS,
                            )
                        )
                    ),
                    MealGroup(
                        type = MealGroupType.SNACK,
                        mealItems = listOf(
                            MealItem(
                                quantity = 30.0,
                                name = "egg whites",
                                units = FoodMeasurementUnit.GRAMS,
                            ),
                            MealItem(
                                quantity = 50.0,
                                name = "Milk",
                                units = FoodMeasurementUnit.MILLILITERS,
                            )
                        )
                    ),
                    MealGroup(
                        type = MealGroupType.LUNCH,
                        mealItems = listOf(
                            MealItem(
                                quantity = 200.0,
                                name = "chicken",
                                units = FoodMeasurementUnit.OUNCES,
                            ),
                            MealItem(
                                quantity = 50.0,
                                name = "Milk",
                                units = FoodMeasurementUnit.MILLILITERS,
                            )
                        )
                    ),
                    MealGroup(
                        type = MealGroupType.SNACK,
                        mealItems = listOf(
                            MealItem(
                                quantity = 50.0,
                                name = "Milk",
                                units = FoodMeasurementUnit.MILLILITERS,
                            ),
                            MealItem(
                                quantity = 50.0,
                                name = "Milk",
                                units = FoodMeasurementUnit.MILLILITERS,
                            )

                        )
                    ),
                    MealGroup(
                        type = MealGroupType.DINNER,
                        mealItems = listOf(
                            MealItem(
                                quantity = 1.0,
                                name = "Nuts",
                                units = FoodMeasurementUnit.GRAMS,
                            ),
                            MealItem(
                                quantity = 20.5,
                                name = "Milk",
                                units = FoodMeasurementUnit.MILLILITERS,
                            )
                        )
                    )
                ),
            ),
            title = "Add New Meal Plan"
        )
    )

    fun updateMealPlan(mealPlan: MealPlan) {
        state.update {
            it.copy(mealPlan = mealPlan)
        }
    }
}