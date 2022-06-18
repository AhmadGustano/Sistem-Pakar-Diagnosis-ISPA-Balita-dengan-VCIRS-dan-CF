package com.example.exsyskotlin

class InputCheck {
    fun checkState (nama:String,usia:String,tinggi:String,berat:String):Int{
        return if (nama!="" && usia!=""&& tinggi!=""&& berat!="" ) {
            1
        }
        else 0
        }
    }