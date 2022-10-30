package com.example.project_tourgo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImagePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_page)

        val pic = findViewById<ImageView>(R.id.pic)
        pic.setOnClickListener {
            val intent = Intent(this,Ulasan::class.java)
            startActivity(intent)
        }
        val pic2 = findViewById<ImageView>(R.id.pic2)
        pic2.setOnClickListener {
            val intent = Intent(this,Ulasan::class.java)
            startActivity(intent)
        }
        val pic3 = findViewById<ImageView>(R.id.pic3)
        pic3.setOnClickListener {
            val intent = Intent(this,Ulasan::class.java)
            startActivity(intent)
        }
        val pic4 = findViewById<ImageView>(R.id.pic4)
        pic4.setOnClickListener {
            val intent = Intent(this,Ulasan::class.java)
            startActivity(intent)
        }
        val pic5 = findViewById<ImageView>(R.id.pic5)
        pic5.setOnClickListener {
            val intent = Intent(this,Ulasan::class.java)
            startActivity(intent)
        }
    }
}