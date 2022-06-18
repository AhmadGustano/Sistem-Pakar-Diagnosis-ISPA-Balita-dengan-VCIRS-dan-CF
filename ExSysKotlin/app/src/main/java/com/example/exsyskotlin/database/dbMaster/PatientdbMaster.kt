package com.example.exsyskotlin.database.dbMaster

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.exsyskotlin.database.dao.PatientDAO
import com.example.exsyskotlin.database.entity.PatientEnt

@Database(entities = [(PatientEnt::class)], version = 1, exportSchema = false)
abstract class PatientdbMaster : RoomDatabase() {

    abstract fun patientDAO(): PatientDAO
}