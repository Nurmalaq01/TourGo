package com.example.project_tourgo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val c:Context,val userList: ArrayList<UserData>) : RecyclerView.Adapter<Adapter.userViewHolder>()
{
    inner class userViewHolder(val v:View) :RecyclerView.ViewHolder(v){
        val mail = v.findViewById<TextView>(R.id.mail)
        val input = v.findViewById<TextView>(R.id.input)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val inflater = LayoutInflater.from((parent.context))
        val v = inflater.inflate(R.layout.listitem,parent,false)
        return userViewHolder(v)
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        val newList = userList[position]
        holder.mail.text = newList.email
        holder.input.text = newList.text
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}