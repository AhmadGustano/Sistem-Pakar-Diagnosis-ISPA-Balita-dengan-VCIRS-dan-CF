package com.example.exsyskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_patient_data_page.*

class DiagnosisInputPage : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_patient_data_page)
        btnNext.setOnClickListener {
            val inputpage = Intent(this,DiagnosisPage::class.java)
            val RGJenisKelamin = RadioGroupJK.checkedRadioButtonId
            val JenisKelamin = findViewById<RadioButton>(RGJenisKelamin)

            //intent data
            inputpage.putExtra("NamaPasien",edt_NamaPasien.text.toString().trim())
            inputpage.putExtra("UsiaPasien",edt_UsiaPasien.text.toString().trim())
            inputpage.putExtra("JKPasien",JenisKelamin.text.toString())
            inputpage.putExtra("TinggiPasien",edt_TinggiPasien.text.toString().trim())
            inputpage.putExtra("BeratPasien",edt_BeratPasien.text.toString().trim())
            startActivity(inputpage)
        }
    }
}
