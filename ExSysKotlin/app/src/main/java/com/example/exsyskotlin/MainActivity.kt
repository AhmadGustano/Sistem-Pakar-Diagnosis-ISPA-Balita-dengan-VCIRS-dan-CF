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
        val adminPage = Intent(this, AdminLandingPage::class.java)
        val login = LoginCheck()
        btnLogin.setOnClickListener {
            val state = login.checkState(editUser.text.toString(),editPass.text.toString())
            if(state==0){
                Toast.makeText(applicationContext, "Login Sukses",
                    Toast.LENGTH_SHORT).show()
                intentAdminPage(adminPage)
            }
            else if(state==1){
                Toast.makeText(applicationContext, "Username dan Password Tidak Boleh Kosong",
                    Toast.LENGTH_SHORT).show()
            }
            else if(state==2) {
                Toast.makeText(applicationContext, "Username atau Password Salah",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun intentAdminPage(adminPage : Intent) {
        startActivity(adminPage)
        finish()
    }
}