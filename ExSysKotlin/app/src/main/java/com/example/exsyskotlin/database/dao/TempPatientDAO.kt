package com.example.exsyskotlin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.exsyskotlin.database.entity.TempPatientEnt

@Dao
interface TempPatientDAO {
    @Insert
    fun simpanTempPatient(tempPatientEnt: TempPatientEnt)

    @Query("Select * from TempPatientEnt")
    fun getTempPatientList(): MutableList<TempPatientEnt>

//    @Query("DELETE FROM TempPatientEntity")
//    fun nukePatientDAO()
}