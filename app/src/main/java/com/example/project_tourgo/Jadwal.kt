package com.example.project_tourgo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Jadwal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal)

        val home5 = findViewById<ImageButton>(R.id.home5)
        home5.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        val image3 = findViewById<ImageButton>(R.id.image3)
        image3.setOnClickListener {
            val intent = Intent(this, ImagePage::class.java)
            startActivity(intent)
        }
        val calendar3 = findViewById<ImageButton>(R.id.calendar3)
        calendar3.setOnClickListener {
            val intent = Intent(this, Jadwal::class.java)
            startActivity(intent)
        }
        val profil3 = findViewById<ImageButton>(R.id.profil3)
        profil3.setOnClickListener {
            val intent = Intent(this, ProfilPage::class.java)
            startActivity(intent)
        }
    }
}