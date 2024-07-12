package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapi.network.NetworkResult
import com.example.model.UserData
import com.example.repo.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (private val repository: UserRepository) : ViewModel() {
    private val user_m = MutableLiveData<NetworkResult<UserData>>()
    val user : LiveData<NetworkResult<UserData>>
        get() = user_m

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getUsers()
            user_m.postValue(result)
        }
    }
}