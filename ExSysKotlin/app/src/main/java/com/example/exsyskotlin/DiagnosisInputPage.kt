package com.example.exsyskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_patient_data_page.*

class DiagnosisInputPage : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_patient_data_page)
        var inputPage : Intent
        var rgJenisKelamin : Int
        var jenisKelamin : RadioButton
        val input = InputCheck()
        btnNext.setOnClickListener {
            inputPage = Intent(this,DiagnosisPage::class.java)
            rgJenisKelamin = RadioGroupJK.checkedRadioButtonId
            jenisKelamin = findViewById(rgJenisKelamin)
            val state = input.checkState(edt_NamaPasien.text.toString(),edt_UsiaPasien.text.toString()
            ,edt_TinggiPasien.text.toString(),edt_BeratPasien.text.toString())
            if(state==0 ){
                sentData(inputPage,jenisKelamin)
            }
            else{
                Toast.makeText(applicationContext, "Mohon Periksa Form Kembali",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sentData(inputPage : Intent, jenisKelamin : RadioButton){
        //intent data
        inputPage.putExtra("NamaPasien",edt_NamaPasien.text.toString().trim())
        inputPage.putExtra("UsiaPasien",edt_UsiaPasien.text.toString().trim())
        inputPage.putExtra("JKPasien",jenisKelamin.text.toString())
        inputPage.putExtra("TinggiPasien",edt_TinggiPasien.text.toString().trim())
        inputPage.putExtra("BeratPasien",edt_BeratPasien.text.toString().trim())
        startActivity(inputPage)
        finish()
    }
}
