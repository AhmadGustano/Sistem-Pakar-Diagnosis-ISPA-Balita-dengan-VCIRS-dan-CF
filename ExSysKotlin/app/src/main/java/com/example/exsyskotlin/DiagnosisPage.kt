package com.example.exsyskotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.exsyskotlin.database.dbMaster.PatientdbMaster
import com.example.exsyskotlin.database.dbMaster.TempPatientdbMaster
import com.example.exsyskotlin.database.entity.PatientEnt
import com.example.exsyskotlin.database.entity.TempPatientEnt
import kotlinx.android.synthetic.main.activity_diagnosis_page.*

class DiagnosisPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnosis_page)

        //initialization
        val dbPasien =
            Room.databaseBuilder(applicationContext, PatientdbMaster::class.java, "DataPasien")
                .allowMainThreadQueries().build()
        val dbHasilDiagnosis =
            Room.databaseBuilder(applicationContext, TempPatientdbMaster::class.java, "HasilDiagnosisPasien")
                .allowMainThreadQueries().build()
        val patientEntity = PatientEnt()
        val tempPatientEntity = TempPatientEnt()
        val intentPage = Intent(this, DiagnosisOutputPage::class.java)
        
        var hasilDiagnosis = ""
        var valueCFRTotal: Double
        var valueCFRTotalString = ""
        val vcirs = VCIRS()
        var getDoubleQPneumonia : Array<Double>
        var getDoubleQISPA : Array<Double>

        //getradiogroup
        var rgQ1 :Int
        var rgQ2 :Int
        var rgQ3 :Int
        var rgQ4 :Int
        var rgQ5 :Int
        var rgQ6 :Int
        var rgQ7 :Int
        var rgQ8 :Int
        var rgQ9 :Int
        var rgQ10P :Int
        var rgQ10 :Int
        var rgQ11 :Int

        //getradiobutton
        var q1 : RadioButton
        var q2 : RadioButton
        var q3 : RadioButton
        var q4 : RadioButton
        var q5 : RadioButton
        var q6 : RadioButton
        var q7 : RadioButton
        var q8 : RadioButton
        var q9 : RadioButton
        var q10P : RadioButton
        var q10 : RadioButton
        var q11 : RadioButton

        //stringQ
        var getQ1 : String
        var getQ2 : String
        var getQ3 : String
        var getQ4 : String
        var getQ5 : String
        var getQ6 : String
        var getQ7 : String
        var getQ8 : String
        var getQ9 : String
        var getQ10P : String
        var getQ10 : String
        var getQ11 : String

        //doubleQ
        var getDoubleQ1 : Double
        var getDoubleQ2 : Double
        var getDoubleQ3 : Double
        var getDoubleQ4 : Double
        var getDoubleQ5 : Double
        var getDoubleQ6 : Double
        var getDoubleQ7 : Double
        var getDoubleQ8 : Double
        var getDoubleQ9 : Double
        var getDoubleQ10P : Double
        var getDoubleQ10 : Double
        var getDoubleQ11 : Double

        //getdata from previous page
        val getNamaPasien = intent.getStringExtra("NamaPasien")
        val getUsiaPasien = intent.getStringExtra("UsiaPasien")
        val getJKPasien = intent.getStringExtra("JKPasien")
        val getTinggiPasien = intent.getStringExtra("TinggiPasien") + "cm"
        val getBeratPasien = intent.getStringExtra("BeratPasien") + "kg"

        //setdata txt to activity_diagnosis_page.xml
        txt_JdlNamaPasien2.text=getNamaPasien
        txt_JdlUsiaPasien2.text=getUsiaPasien
        txt_JdlJkPasien2.text=getJKPasien


        //button diagnosis
        btnDiagnosis.setOnClickListener {


            //getjawaban
            rgQ1 = RadioGroup1.checkedRadioButtonId
            q1 = findViewById(rgQ1)
            getQ1 = getValQ(q1.text.toString())

            rgQ2 = RadioGroup2.checkedRadioButtonId
            q2 = findViewById(rgQ2)
            getQ2 = getValQ(q2.text.toString())

            rgQ3 = RadioGroup3.checkedRadioButtonId
            q3 = findViewById(rgQ3)
            getQ3 = getValQ(q3.text.toString())

            rgQ4 = RadioGroup4.checkedRadioButtonId
            q4 = findViewById(rgQ4)
            getQ4 = getValQ(q4.text.toString())

            rgQ5 = RadioGroup5.checkedRadioButtonId
            q5 = findViewById(rgQ5)
            getQ5 = getValQ(q5.text.toString())

            rgQ6 = RadioGroup6.checkedRadioButtonId
            q6 = findViewById(rgQ6)
            getQ6 = getValQ(q6.text.toString())

            rgQ7 = RadioGroup7.checkedRadioButtonId
            q7 = findViewById(rgQ7)
            getQ7 = getValQ(q7.text.toString())

            rgQ8 = RadioGroup8.checkedRadioButtonId
            q8 = findViewById(rgQ8)
            getQ8 = getValQ(q8.text.toString())

            rgQ9 = RadioGroup9.checkedRadioButtonId
            q9 = findViewById(rgQ9)
            getQ9 = getValQ(q9.text.toString())

            rgQ10 = RadioGroup10.checkedRadioButtonId
            q10 = findViewById(rgQ10)
            getQ10 = getValQ(q10.text.toString())

            rgQ10P = RadioGroup10pneumonia.checkedRadioButtonId
            q10P = findViewById(rgQ10P)
            getQ10P = getValQ(q10P.text.toString())

            rgQ11 = RadioGroup11.checkedRadioButtonId
            q11 = findViewById(rgQ11)
            getQ11 = getValQ(q11.text.toString())

            //Q value String to Double
            getDoubleQ1 = getValQtoDouble(getQ1)
            getDoubleQ2 = getValQtoDouble(getQ2)
            getDoubleQ3 = getValQtoDouble(getQ3)
            getDoubleQ4 = getValQtoDouble(getQ4)
            getDoubleQ5 = getValQtoDouble(getQ5)
            getDoubleQ6 = getValQtoDouble(getQ6)
            getDoubleQ7 = getValQtoDouble(getQ7)
            getDoubleQ8 = getValQtoDouble(getQ8)
            getDoubleQ9 = getValQtoDouble(getQ9)
            getDoubleQ10P = getValQtoDouble(getQ10P)
            getDoubleQ10 = getValQtoDouble(getQ10)
            getDoubleQ11 = getValQtoDouble(getQ11)

            //if q10P 1 maka diagnosis Pneumonia
            if (getQ10P == "1") {
                val state=1
            //put getDoubleQ to array
                getDoubleQPneumonia = arrayOf(
                getDoubleQ1, getDoubleQ2, getDoubleQ3, getDoubleQ4, getDoubleQ5, getDoubleQ6, getDoubleQ7, getDoubleQ8,
                getDoubleQ9, getDoubleQ10P, getDoubleQ10, getDoubleQ11)

                valueCFRTotal = processDiagnose(getDoubleQPneumonia,vcirs,state)

                if(valueCFRTotal>0){
                    hasilDiagnosis = "Pneumonia"
                    valueCFRTotalString = valueCFRTotal.toString()
                }
//                else if(valueCFRTotal<=50 && valueCFRTotal>0){
//                   hasilDiagnosis = "Pneumonia (Tingkat Keyakinan Rendah)"
//                    valueCFRTotalString = valueCFRTotal.toString()
//                }
                else if(valueCFRTotal<=0){
                    hasilDiagnosis = "Pasien Tidak Terkena Penyakit ISPA/Pneumonia"
                    valueCFRTotalString = valueCFRTotal.toString()
                }
             }

            //if q10P 0 maka diagnosis ISPA
            else if(getQ10P=="0"){
                //put getDoubleQ to array
                    val state =0
                 getDoubleQISPA = arrayOf(
                    getDoubleQ1, getDoubleQ2, getDoubleQ3, getDoubleQ4, getDoubleQ5, getDoubleQ6, getDoubleQ7, getDoubleQ8,
                    getDoubleQ9,getDoubleQ10, getDoubleQ11)

                valueCFRTotal = processDiagnose(getDoubleQISPA,vcirs,state)

                if(valueCFRTotal>0){
                    hasilDiagnosis = "ISPA"
                    valueCFRTotalString = valueCFRTotal.toString()
                }
//                else if(valueCFRTotal<=50 && valueCFRTotal>0){
//                    hasilDiagnosis = "ISPA (Tingkat Keyakinan Rendah)"
//                    valueCFRTotalString = valueCFRTotal.toString()
//                }
                else if(valueCFRTotal<=0){
                    hasilDiagnosis = "Pasien Tidak Terkena Penyakit ISPA/Pneumonia"
                    valueCFRTotalString = valueCFRTotal.toString()
                }
            }

            //if all Q = 0
            else if(getQ1=="0" && getQ2=="0" && getQ3=="0" && getQ4=="0" && getQ5=="0" && getQ6=="0"
                && getQ7=="0" && getQ8=="0" && getQ9=="0" && getQ10=="0" && getQ10P=="0" && getQ11 =="0"){
                hasilDiagnosis = "Pasien Tidak Terkena Penyakit ISPA/Pneumonia"
                valueCFRTotalString= "0"
            }

            //inputdata to patientEntity
            patientEntity.pasienNama = getNamaPasien
            patientEntity.pasienUsia = getUsiaPasien
            patientEntity.pasienJK = getJKPasien
            patientEntity.pasienTinggi = getTinggiPasien
            patientEntity.pasienBerat = getBeratPasien
            patientEntity.q1 = getQ1
            patientEntity.q2 = getQ2
            patientEntity.q3 = getQ3
            patientEntity.q4 = getQ4
            patientEntity.q5 = getQ5
            patientEntity.q6 = getQ6
            patientEntity.q7 = getQ7
            patientEntity.q8 = getQ8
            patientEntity.q9 = getQ9
            patientEntity.q10 = getQ10
            patientEntity.q10P = getQ10P
            patientEntity.q11 = getQ11
            patientEntity.hasilPerhitungan = valueCFRTotalString
            patientEntity.hasilDiagnosis = hasilDiagnosis

            //inputdata to tempPatientEntity
            tempPatientEntity.pasienNama = getNamaPasien
            tempPatientEntity.pasienUsia = getUsiaPasien
            tempPatientEntity.pasienJK = getJKPasien
            tempPatientEntity.pasienTinggi = getTinggiPasien
            tempPatientEntity.pasienBerat = getBeratPasien
            tempPatientEntity.hasilPerhitungan = valueCFRTotalString
            tempPatientEntity.hasilDiagnosis = hasilDiagnosis

            //simpandata to db patientEntity
            saveData(dbPasien,patientEntity)

            //simpandata to db tempPatientEntity
            saveDataResult(dbHasilDiagnosis,tempPatientEntity)

            Toast.makeText(applicationContext, "data pasien tersimpan", Toast.LENGTH_LONG).show()

            //send data to DiagnosisOutputPage
            intentPage.putExtra("NamaPasien",getNamaPasien)
            intentPage.putExtra("UsiaPasien",getUsiaPasien)
            intentPage.putExtra("JKPasien",getJKPasien)
            intentPage.putExtra("HasilDiagnosis",hasilDiagnosis)
            intentPage.putExtra("CFRTotal",valueCFRTotalString)
            intentOutputPage(intentPage)
        }
    }

    //StringJawabanTo 1 or 0
    private fun getValQ(q:String): String {
        return if(q =="Ya"){
            "1"
        } else {
            "0"
        }
    }

    //String to Double
    private fun getValQtoDouble(q:String):Double{
        return q.toDouble()
    }

    private fun processDiagnose(getDoubleQ : Array<Double>, vcirs : VCIRS, state: Int) : Double{
        val cfrTotal : Double
        val valueVUR : DoubleArray
        val valueNUR : Double
        val valueRUR: Double
        val cfrValueHE : DoubleArray

        //calculate CF Value(H,E)
        val cfValueHE : DoubleArray = vcirs.calculateCFValueHE(getDoubleQ,state)
                //get Variable Order
        val variableOrder :DoubleArray = vcirs.getVariableOrder(getDoubleQ)
                //get Total Variable
        val totalVariable :Double = vcirs.getTotalVariable(getDoubleQ)
                //calculate VUR
                valueVUR = vcirs.calculateVUR(getDoubleQ,variableOrder,totalVariable)
                //calculate NUR
        
                valueNUR = vcirs.calculateNUR(valueVUR,totalVariable)
                //calculate RUR
                valueRUR = vcirs.calculateRUR(valueNUR)
                 Log.d("tes1",valueRUR.toString())
                //calculate CFR Total
                cfrValueHE = vcirs.calculateCFRValue(cfValueHE,valueRUR)
                Log.d("tes2",cfrValueHE.toString())
                cfrTotal = vcirs.calculateCFRTotal(cfrValueHE)
                Log.d("tes3",cfrTotal.toString())
        return cfrTotal
    }

    private fun saveData(dbPasien : PatientdbMaster, patientEnt : PatientEnt){
        val db = dbPasien
        db.patientDAO().simpanPatient(patientEnt)
    }

    private fun saveDataResult(dbPasien : TempPatientdbMaster, patientEnt : TempPatientEnt){
        val db = dbPasien
        db.temppatientDAO().simpanTempPatient(patientEnt)
    }

    private fun intentOutputPage(intentPage : Intent){
        startActivity(intentPage)
        finish()
    }
}