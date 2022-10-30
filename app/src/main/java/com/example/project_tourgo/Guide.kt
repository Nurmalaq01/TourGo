package com.example.project_tourgo

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity

class Guide : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        val flipper = findViewById<ViewFlipper>(R.id.flipper)
        fun previousView() {
            flipper.showPrevious()
            val animin = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        }
        fun nextView(){
            flipper.showNext()
            val animout = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)
        }

        val previous = findViewById<Button>(R.id.previous)
        previous.setOnClickListener {
                v->previousView()
        }
        val next = findViewById<Button>(R.id.next)
        next.setOnClickListener {
                v->nextView()
        }
        val home3 = findViewById<ImageButton>(R.id.home3)
        home3.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        val ok2 = findViewById<Button>(R.id.ok2)
        ok2.setOnClickListener {
            val intent = Intent(this, Jadwal::class.java)
            startActivity(intent)
        }
    }
}