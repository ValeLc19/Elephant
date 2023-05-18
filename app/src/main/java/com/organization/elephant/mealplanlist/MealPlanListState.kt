package com.organization.elephant.mealplanlist

import com.organization.elephant.data.models.MealPlan

data class MealPlanListState(
    val title:String,
    val mealPlans:List<MealPlan>
)
