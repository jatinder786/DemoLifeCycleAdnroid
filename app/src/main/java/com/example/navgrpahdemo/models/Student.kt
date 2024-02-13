package com.example.navgrpahdemo.models

import android.util.Log

class Area:AddNumber{
    override fun addNumber() {
        TODO("Not yet implemented")
    }

}
class Student<T>(name:T):Animal<T>(name) {
    val addNumber=Area()

     override fun avoidCall(name: String) {
         Log.e("Student","$name Start Crapping..")
     }

 }


class Age<T>(t:T)
{
    var data=t

    init {
        Log.e("Data","$data" )
    }
}


fun interface AddNumber
{
    fun addNumber()

}



