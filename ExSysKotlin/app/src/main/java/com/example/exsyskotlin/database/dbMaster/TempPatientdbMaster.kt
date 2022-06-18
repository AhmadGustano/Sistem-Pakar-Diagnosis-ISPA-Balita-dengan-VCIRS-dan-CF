package com.example.exsyskotlin.database.dbMaster

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.exsyskotlin.database.dao.TempPatientDAO
import com.example.exsyskotlin.database.entity.TempPatientEnt

@Database(entities = [(TempPatientEnt::class)], version = 2, exportSchema = false)
abstract class TempPatientdbMaster : RoomDatabase() {

    abstract fun temppatientDAO(): TempPatientDAO
}