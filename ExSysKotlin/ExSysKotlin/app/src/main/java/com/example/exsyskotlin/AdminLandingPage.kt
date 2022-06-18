package com.example.exsyskotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_page_admin.*

class AdminLandingPage : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_admin)
        icon_diagnosis.setOnClickListener{
        val inputpage = Intent(this,DiagnosisInputPage::class.java)
            startActivity(inputpage)
     }
   }
}