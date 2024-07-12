package com.example.view.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapi.network.NetworkResult
import com.example.userapi.databinding.ActivityMainBinding

import com.example.model.UserData
import com.example.model.UserDataItem
import com.example.myapp.MyApplication
import com.example.userapi.R
import com.example.view.ui.adapter.UserAdapter
import com.example.viewmodel.UserViewModel
import com.example.viewmodel.UserViewModelFactory



class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView
    var arrayList: ArrayList<UserDataItem> = arrayListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        val repository = (application as MyApplication).userRepository

        userViewModel = ViewModelProvider(this, UserViewModelFactory(repository)).get(
            UserViewModel::class.java
        )

        userViewModel.getUsers()
        initObserver()

    }

    private fun initObserver() {
        userViewModel.user.observe(this){
            when(it){
                is NetworkResult.Loading ->{

                }
                is NetworkResult.Success ->{
                    arrayList.addAll(it.data!!)
                    val userAdapter = UserAdapter(this, arrayList)
                    recyclerView.adapter = userAdapter
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this, "data Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}