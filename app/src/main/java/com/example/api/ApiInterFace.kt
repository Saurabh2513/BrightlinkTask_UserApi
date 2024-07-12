package com.example.api



import com.example.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterFace {
    @GET("users")
    suspend fun getData(): Response<UserData>
}