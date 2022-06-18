package com.example.exsyskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            if (editUser.text.toString() == "admin" && editPass.text.toString() == "admin") {
                Toast.makeText(applicationContext, "Login Sukses", Toast.LENGTH_SHORT).show()
                intentAdminPage()
            } else {
                Toast.makeText(applicationContext, "Username atau Password Anda Salah",
                        Toast.LENGTH_SHORT).show()
            }
        }
//        btnCancel.setOnClickListener {
//            finish()
//        }
    }

private fun intentAdminPage() {
    val adminPage = Intent(this, AdminLandingPage::class.java)
    startActivity(adminPage)
}
}