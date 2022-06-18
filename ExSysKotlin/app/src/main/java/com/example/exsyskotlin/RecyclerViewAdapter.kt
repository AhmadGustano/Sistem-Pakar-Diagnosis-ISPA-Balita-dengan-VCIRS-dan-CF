package com.example.exsyskotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exsyskotlin.database.entity.TempPatientEnt

class RecyclerViewAdapter(private val patientEnt : MutableList<TempPatientEnt>):RecyclerView.Adapter
            <ViewHolderPatient>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPatient =
        ViewHolderPatient(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_data_page,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holderPatient: ViewHolderPatient, position: Int) {
        holderPatient.bindItem(patientEnt[position])
    }

    override fun getItemCount(): Int = patientEnt.size

}