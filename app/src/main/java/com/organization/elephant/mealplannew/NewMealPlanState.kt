package com.organization.elephant.mealplannew

import com.organization.elephant.data.models.MealPlan

data class NewMealPlanState(
    val mealPlan:MealPlan,
    val title:String
)