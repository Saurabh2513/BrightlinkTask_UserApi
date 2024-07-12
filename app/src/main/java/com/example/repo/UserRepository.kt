package com.example.repo

import com.example.api.ApiInterFace
import com.example.bookapi.network.NetworkResult
import com.example.model.UserData
import com.example.model.UserDataItem

class UserRepository(private val apiInterFace: ApiInterFace) {

    suspend fun getUsers(): NetworkResult<UserData> {
        val response=apiInterFace.getData()
        return  if (response.isSuccessful){
            val responseBody=response.body()
            if (responseBody!= null){
                NetworkResult.Success(responseBody)
            }else{
                NetworkResult.Error("Something went wrong")
            }
        }else{
            NetworkResult.Error("Something went wrong")
        }
    }
}