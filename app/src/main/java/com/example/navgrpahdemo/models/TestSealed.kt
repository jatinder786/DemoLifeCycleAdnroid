package com.example.navgrpahdemo.models

import android.util.Log

sealed class Animal<T>(name: T) {
    data class Dog(private val name:String="Jatinder"):Animal<String>(name = name) {
        override fun avoidCall(name: String) {
            Log.e("dog","$name Start BARKING")
        }
    }

    class Cow(name: Int):Animal<String>(name = name.toString()) {
        override fun avoidCall(name: String) {
            Log.e("Cow","$name Start Chewing")
        }
    }

    abstract fun avoidCall(name: String)
}
enum class Names{
    JATINDER,
    MONINDER,
    SUNIL}
enum class Status(status:String)
{
    ON(status = "ON"),
    OFF(status = "OFF")
}


