package com.example.project_tourgo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.project_tourgo.databinding.ActivityPaymentBinding

class Payment : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val items = listOf("Laki-Laki", "Perempuan")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        binding.dropdownField.setAdapter(adapter)

        val ok3 = findViewById<Button>(R.id.ok3)
        ok3.setOnClickListener {
            val intent = Intent(this,Jadwal::class.java)
            startActivity(intent)
        }
        val home3 = findViewById<ImageButton>(R.id.home3)
        home3.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }
}