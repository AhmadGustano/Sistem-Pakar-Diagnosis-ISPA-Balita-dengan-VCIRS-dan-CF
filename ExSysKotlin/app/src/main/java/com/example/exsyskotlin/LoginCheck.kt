package com.example.exsyskotlin

class LoginCheck {
    fun checkState (username:String,password:String):Int{
        return if (username == "admin" && password == "admin") {
            1
        } else if (username == "" && password == "") {
           2
        } else{
            3
        }
    }
}