package com.example.exsyskotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_diagnosis_output_page.*

class DiagnosisOutputPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnosis_output_page)
        val inputReturnPage= Intent(this,AdminLandingPage::class.java)

//        getdata from previous page
        val getNamaPasien = intent.getStringExtra("NamaPasien").toString()
        val getUsiaPasien = intent.getStringExtra("UsiaPasien").toString()
        val getJKPasien = intent.getStringExtra("JKPasien").toString()
        val getHasilDiagnosis = intent.getStringExtra("HasilDiagnosis").toString()
        val getCFRTotal = intent.getStringExtra("CFRTotal").toString()

        setDataResult(getNamaPasien,getUsiaPasien,getJKPasien,getHasilDiagnosis,getCFRTotal)

        //button back to main menu
        btnBackMenu.setOnClickListener {
            intentBacktoMainMenu(inputReturnPage)
        }
    }

    private fun setDataResult(getNamaPasien : String, getUsiaPasien : String, getJKPasien : String,
                              getHasilDiagnosis : String, getCFRTotal : String){
        val txtCF = "Nilai Keyakinan Sistem :$getCFRTotal%"
        txt_JdlNamaPasien3.text=getNamaPasien
        txt_JdlUsiaPasien3.text=getUsiaPasien
        txt_JdlJkPasien3.text=getJKPasien
        txt_OutputDiagnosis.text=getHasilDiagnosis
        if(txt_OutputDiagnosis.text == "Pasien Tidak Terkena Penyakit ISPA/Pneumonia"){
            txt_OutputDiagnosis.textSize = 15F
        }
        txt_OutputVCIRS.text=txtCF
        txt_OutputVCIRS.textSize = 15F
    }

    private fun intentBacktoMainMenu(inputReturnPage : Intent){
        startActivity(inputReturnPage)
        finish()
    }
}