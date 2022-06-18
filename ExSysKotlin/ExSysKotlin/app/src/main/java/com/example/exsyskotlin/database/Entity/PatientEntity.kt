package com.example.exsyskotlin.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PatientEntity(
    @PrimaryKey
    @ColumnInfo(name = "PatsienId")
    var PasienId: Long?=null,

    @ColumnInfo(name = "PasienName")
    var PatsienName: String?=null,

    @ColumnInfo(name = "PasienUsia")
    var PasienUsia: String?=null,

    @ColumnInfo(name = "PasienJK")
    var PasienJK: String?=null,

    @ColumnInfo(name = "PasienTinggi")
    var PasienTinggi: String?=null,

    @ColumnInfo(name = "PasienBerat")
    var PasienBerat: String?=null
)