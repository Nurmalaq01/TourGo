package com.example.project_tourgo

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.actionCodeSettings
import java.util.*

class HomePage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val click = findViewById<Button>(R.id.click)
        click.setOnClickListener {
            val intent = Intent(this, WisataPage::class.java)
            startActivity(intent)

        }
        val tgl = findViewById<TextView>(R.id.tanggal)
        tgl.setOnClickListener {
            val c = Calendar.getInstance()
            c.add(Calendar.YEAR,18)
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dp = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val months = monthOfYear+1
                    tgl.setText("$dayOfMonth-$month-$year")
                },year,month,day)
            dp.datePicker.maxDate = c.timeInMillis
            dp.show()
        }
        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        val image = findViewById<ImageButton>(R.id.image)
        image.setOnClickListener {
            val intent = Intent(this, ImagePage::class.java)
            startActivity(intent)
        }
        val calendar = findViewById<ImageButton>(R.id.calendar)
        calendar.setOnClickListener {
            val intent = Intent(this, Jadwal::class.java)
            startActivity(intent)
        }
        val profil = findViewById<ImageButton>(R.id.profil)
        profil.setOnClickListener {
            val intent = Intent(this, ProfilPage::class.java)
            startActivity(intent)
        }
        val actionCodeSettings = actionCodeSettings {
            // URL you want to redirect back to. The domain (www.example.com) for this
            // URL must be whitelisted in the Firebase Console.
            url = "https://www.example.com/finishSignUp?cartId=1234"
            // This must be true
            handleCodeInApp = true
            setIOSBundleId("com.example.ios")
            setAndroidPackageName(
                "com.example.android",
                true, /* installIfNotAvailable */
                "12" /* minimumVersion */)
        }

    }
}