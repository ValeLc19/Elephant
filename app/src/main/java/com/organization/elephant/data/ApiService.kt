package com.organization.elephant.data

import com.organization.elephant.data.models.MealPlan
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AppApiService {

    @GET("mealPlan")
    suspend fun getMealPlans(): Response<List<MealPlan>>
}

object AppApi{
    private const val BASE_URL = "http://10.20.20.241:8080"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService:AppApiService by lazy {
        retrofit.create(AppApiService::class.java)
    }
}