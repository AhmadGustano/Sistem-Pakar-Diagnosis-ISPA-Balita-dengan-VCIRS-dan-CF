package com.example.exsyskotlin.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PatientEnt(
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

    @ColumnInfo(name = "QSatu")
    var q1: String?=null,

    @ColumnInfo(name = "QDua")
    var q2: String?=null,

    @ColumnInfo(name = "QTiga")
    var q3: String?=null,

    @ColumnInfo(name = "QEmpat")
    var q4: String?=null,

    @ColumnInfo(name = "QLima")
    var q5: String?=null,

    @ColumnInfo(name = "QEnam")
    var q6: String?=null,

    @ColumnInfo(name = "QTujuh")
    var q7: String?=null,

    @ColumnInfo(name = "QDelapan")
    var q8: String?=null,

    @ColumnInfo(name = "QSembilan")
    var q9: String?=null,

    @ColumnInfo(name = "QSepuluh")
    var q10: String?=null,

    @ColumnInfo(name = "QSepuluhP")
    var q10P: String?=null,

    @ColumnInfo(name = "QSebelas")
    var q11: String?=null,

    @ColumnInfo(name = "HasilPerhitungan")
    var hasilPerhitungan: String?=null,

    @ColumnInfo(name = "HasilDiagnosis")
    var hasilDiagnosis: String?=null
)