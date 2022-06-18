package com.example.exsyskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_diagnosis_page.*

class DiagnosisPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnosis_page)

        //getdata
        val getNamaPasien = intent.getStringExtra("NamaPasien")
        val getUsiaPasien = intent.getStringExtra("UsiaPasien")
        val getJKPasien = intent.getStringExtra("JKPasien")
        val getTinggiPasien = intent.getStringExtra("TinggiPasien")
        val getBeratPasien = intent.getStringExtra("BeratPasien")

        //setdata
        txt_JdlNamaPasien2.text=getNamaPasien
        txt_JdlUsiaPasien2.text=getUsiaPasien
        txt_JdlJkPasien2.text=getJKPasien
    }
}