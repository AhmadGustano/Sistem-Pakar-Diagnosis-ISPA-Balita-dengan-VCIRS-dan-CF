package com.example.exsyskotlin.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TempPatientEnt(
    @PrimaryKey
    @ColumnInfo(name = "PasienId")
    var pasienId: Long?=null,

    @ColumnInfo(name = "PasienNama")
    var pasienNama: String?=null,

    @ColumnInfo(name = "PasienUsia")
    var pasienUsia: String?=null,

    @ColumnInfo(name = "PasienJK")
    var pasienJK: String?=null,

    @ColumnInfo(name = "PasienTinggi")
    var pasienTinggi: String?=null,

    @ColumnInfo(name = "PasienBerat")
    var pasienBerat: String?=null,

    @ColumnInfo(name = "HasilPerhitungan")
    var hasilPerhitungan: String?=null,

    @ColumnInfo(name = "HasilDiagnosis")
    var hasilDiagnosis: String?=null
)