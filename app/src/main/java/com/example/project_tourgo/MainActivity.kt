package com.example.project_tourgo

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_tourgo.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val next = findViewById<TextView>(R.id.next)
        next.setOnClickListener {
            val intent = Intent(this, registrasi::class.java)
            startActivity(intent)
        }
        val Login = findViewById<Button>(R.id.Login)
        Login.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)

        }

        binding.next.setOnClickListener{
            val intent= Intent(this, registrasi::class.java)
            startActivity(intent)
        }

        binding.Login.setOnClickListener{
            val email = binding.logemail.text.toString()
            val password = binding.logpass.text.toString()

            //Validasi
            if (email.isEmpty()){
                binding.logemail.error="email Salah"
                binding.logemail.requestFocus()
                return@setOnClickListener
            }

            if(password.length<5){
                binding.logpass.error="Password Harus Minimal 5 Karakter"
                binding.logpass.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.logemail.error="Email Tidak Valid"
                binding.logemail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                binding.logpass.error="Password Harus Diisi"
                binding.logpass.requestFocus()
                return@setOnClickListener
            }



            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful) {
                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomePage::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}