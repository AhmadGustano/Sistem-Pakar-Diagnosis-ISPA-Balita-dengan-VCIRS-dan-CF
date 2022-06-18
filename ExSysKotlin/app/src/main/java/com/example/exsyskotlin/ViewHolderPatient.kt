package com.example.exsyskotlin

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exsyskotlin.database.entity.TempPatientEnt

class ViewHolderPatient(view: View) : RecyclerView.ViewHolder(view) {
    private val txtPasienID: TextView = view.findViewById(R.id.txt_JdlDataIdPasien)
    private val txtPasienNama: TextView = view.findViewById(R.id.txt_JdlDataNamaPasien)
    private val txtPasienUsia: TextView = view.findViewById(R.id.txt_JdlDataUsiaPasien)
    private val txtPasienJK: TextView = view.findViewById(R.id.txt_JdlDataJKPasien)
    private val txtPasienTinggi: TextView = view.findViewById(R.id.txt_JdlDataTinggiPasien)
    private val txtPasienBerat: TextView = view.findViewById(R.id.txt_JdlDataBeratPasien)
    private val txtPasienHasilPerhitungan: TextView = view.findViewById(R.id.txt_JdlDataHasilPerhitunganPasien)
    private val txtPasienHasilDiagnosis: TextView = view.findViewById(R.id.txt_JdlDataHasilDiagnosisPasien)

    @SuppressLint("SetTextI18n")
    fun bindItem(dataItem: TempPatientEnt) {
        txtPasienID.text = dataItem.pasienId.toString()
        txtPasienNama.text = dataItem.pasienNama
        txtPasienUsia.text = dataItem.pasienUsia
        txtPasienJK.text = dataItem.pasienJK
        txtPasienTinggi.text = dataItem.pasienTinggi
        txtPasienBerat.text = dataItem.pasienBerat
        txtPasienHasilPerhitungan.text = dataItem.hasilPerhitungan
        txtPasienHasilDiagnosis.text = dataItem.hasilDiagnosis
        if(txtPasienHasilDiagnosis.text=="Pasien Tidak Terkena Penyakit ISPA/Pneumonia"){
            txtPasienHasilDiagnosis.text = "Tidak ISPA/Pneumonia"
            txtPasienHasilDiagnosis.textSize = 8F
        }
    }
}