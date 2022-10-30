package com.example.project_tourgo

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_tourgo.databinding.ActivityRegistrasiBinding
import com.google.firebase.auth.FirebaseAuth


class registrasi : AppCompatActivity() {

    lateinit var binding: ActivityRegistrasiBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val registry = findViewById<Button>(R.id.registry)
        registry.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        auth = FirebaseAuth.getInstance()


        binding.registry.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val namaawal = binding.etUsername.text.toString()
            val password = binding.etPass.text.toString()

            //Validasi
            if (email.isEmpty()){
                binding.etEmail.error="email Harus Diisi"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }
            if (namaawal.isEmpty()){
                binding.etUsername.error="Username Harus Diisi"
                binding.etUsername.requestFocus()
                return@setOnClickListener
            }

            if(password.length<5){
                binding.etPass.error="Password Harus Minimal 5 Karakter"
                binding.etPass.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etEmail.error="Email Tidak Valid"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                binding.etPass.error="Password Harus Diisi"
                binding.etPass.requestFocus()
                return@setOnClickListener
            }

            if(password.length<5){
                binding.etPass.error="Password Harus Minimal 5 Karakter"
                binding.etPass.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)

        }

    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful) {
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}