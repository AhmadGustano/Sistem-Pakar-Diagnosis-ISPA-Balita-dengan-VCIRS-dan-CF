package com.example.exsyskotlin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.exsyskotlin.database.entity.PatientEnt

@Dao
interface PatientDAO {
    @Insert
    fun simpanPatient(patientEnt: PatientEnt)

    @Query("Select * from PatientEnt")

    fun getPatientList(): MutableList<PatientEnt>

//    @Query("DELETE FROM PatientEntity")
//    fun nukePatientDAO()
}