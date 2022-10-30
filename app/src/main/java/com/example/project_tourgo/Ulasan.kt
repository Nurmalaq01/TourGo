package com.example.project_tourgo

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ulasan : AppCompatActivity() {
    private lateinit var btn : ImageButton
    private lateinit var rcy : RecyclerView
    private lateinit var userList : ArrayList<UserData>
    private lateinit var userAdapter : Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulasan)

        userList = ArrayList()
        rcy = findViewById(R.id.mRecycler)
        btn = findViewById(R.id.button)
        userAdapter = Adapter(this,userList)
        rcy.layoutManager = LinearLayoutManager(this)
        rcy.adapter = userAdapter
        btn.setOnClickListener { review() }
    }

    private fun review() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.add_item,null)
        val email2 = findViewById<EditText>(R.id.put)
        val txt = findViewById<EditText>(R.id.put2)

        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("OK"){
            dialog,_->
            val email3 = email2.text.toString()
            val txt2 = txt.text.toString()
            userList.add(UserData("e-mail: $email3","ulasan: $txt2"))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Add Ulasan Succes",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }

}