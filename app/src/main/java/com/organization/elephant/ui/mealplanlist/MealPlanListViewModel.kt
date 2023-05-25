package com.organization.elephant.ui.mealplanlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.organization.elephant.data.AppApi
import com.organization.elephant.data.AppApiService
import com.organization.elephant.data.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MealPlanListViewModel : ViewModel() {
    var state = MutableStateFlow<MealPlanListState>(
        MealPlanListState(
            title = "All Meal Plans",
            mealPlans = emptyList()
        ),
    )

    init {
        getMealPlans()
    }

    fun getMealPlans(){

        viewModelScope.launch(Dispatchers.IO) {
//            try{
                val mealPlans = AppApi.retrofitService.getMealPlans()
                Log.e("debug", "hwllo")
                println(mealPlans)
//                withContext(Dispatchers.Main){
//                    state.update {
//                        it.copy(mealPlans = mealPlans.body()!!)
//                    }
//                }
//            } catch (e: Exception) {
//                println(e.stackTrace)
//            }
        }


    }
}

