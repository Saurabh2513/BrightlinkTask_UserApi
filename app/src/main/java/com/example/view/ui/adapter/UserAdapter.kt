package com.example.view.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userapi.R
import com.example.model.UserData
import com.example.model.UserDataItem

class UserAdapter(var context: Context, var list: ArrayList<UserDataItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    inner class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
        var img = view.findViewById<ImageView>(R.id.userimage)
        var id = view.findViewById<TextView>(R.id.userid)
        var loginid = view.findViewById<TextView>(R.id.userloginid)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.user_ui,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.count()
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list[position].avatar_url).load(holder.img)
        holder.id.text = list[position].id.toString()
        holder.loginid.text = list[position].login
    }

}