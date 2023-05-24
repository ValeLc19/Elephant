package com.organization.elephant.ui.mealplanlist

import com.organization.elephant.data.models.MealPlan

data class MealPlanListState(
    val title:String,
    val mealPlans:List<MealPlan>
)
