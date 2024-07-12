package com.example.myapp

import android.app.Application
import com.example.repo.UserRepository
import com.example.api.ApiInterFace
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    lateinit var apiInterFace: ApiInterFace
    lateinit var userRepository: UserRepository

    override fun onCreate() {
        super.onCreate()

        // create a retrofit object
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/")
            .build()

        apiInterFace = retrofit.create(ApiInterFace::class.java)
        userRepository = UserRepository(apiInterFace)
    }
}