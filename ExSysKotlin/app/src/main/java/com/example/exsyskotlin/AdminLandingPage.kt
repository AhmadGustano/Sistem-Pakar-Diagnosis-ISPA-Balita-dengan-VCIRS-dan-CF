package com.example.exsyskotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_page_admin.*

class AdminLandingPage : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_admin)
        var inputPage : Intent

       //intent to DiagnosisInputPage
        icon_diagnosis.setOnClickListener{
        inputPage = Intent(this,DiagnosisInputPage::class.java)
            intentDiagnosisPage(inputPage)
     }


       icon_lihatdata.setOnClickListener{
           inputPage = Intent(this,DataPage::class.java)
           intentSeeDataPage(inputPage)
       }

       //button logout
       btnLogout.setOnClickListener{
           inputPage = Intent(this,MainActivity::class.java)
           intentLogoutPage(inputPage)
       }
       
   }

    private fun intentDiagnosisPage(inputPage : Intent) {
        startActivity(inputPage)
        finish()
    }

    private fun intentSeeDataPage(inputPage : Intent) {
        startActivity(inputPage)
        finish()
    }

    private fun intentLogoutPage(inputPage : Intent) {
        startActivity(inputPage)
        finish()
    }
}