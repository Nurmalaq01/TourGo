package com.example.project_tourgo

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class  ProfilPage : AppCompatActivity() {
    private  val REQUEST_IMAGE_GALLERY = 132
    private val REQUEST_IMAGE_CAMERA = 142


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_page)

        val image_user = findViewById<ImageView>(R.id.image_user)
        image_user.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Select Image")
            builder.setMessage("Choose Your Option")
            builder.setPositiveButton("Gallery") { dialog: DialogInterface, which: Int ->
                dialog.dismiss()
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent, REQUEST_IMAGE_GALLERY)
            }
            builder.setNegativeButton("Camera") { dialog: DialogInterface, which: Int ->
                dialog.dismiss()
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent: Intent ->
                    takePictureIntent.resolveActivity(packageManager)?.also {
                        val permission : Int = ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)
                        if (permission!=PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),1)
                        }
                        else {
                            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAMERA)
                        }
                    }
                }
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        val home4 = findViewById<ImageButton>(R.id.home4)
        home4.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        val image2 = findViewById<ImageButton>(R.id.image2)
        image2.setOnClickListener {
            val intent = Intent(this, ImagePage::class.java)
            startActivity(intent)
        }
        val calendar2 = findViewById<ImageButton>(R.id.calendar2)
        calendar2.setOnClickListener {
            val intent = Intent(this, Jadwal::class.java)
            startActivity(intent)
        }
        val profil2 = findViewById<ImageButton>(R.id.profil2)
        profil2.setOnClickListener {
            val intent = Intent(this, ProfilPage::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_GALLERY && requestCode == Activity.RESULT_OK && data != null){
            val image_user = findViewById<ImageView>(R.id.image_user)
            image_user.setImageURI(data.data)
        }
        else if (requestCode == REQUEST_IMAGE_CAMERA && requestCode == Activity.RESULT_OK && data != null){
            val image_user = findViewById<ImageView>(R.id.image_user)
            image_user.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
        else{
            Toast.makeText(this,"Something Went Wrong !",Toast.LENGTH_SHORT).show()
        }
    }



}