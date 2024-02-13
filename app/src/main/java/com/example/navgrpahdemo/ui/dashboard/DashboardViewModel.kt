package com.example.navgrpahdemo.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navgrpahdemo.test.DataLive
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import kotlin.random.Random

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _nameData = MutableLiveData<String>()
    val nameData: LiveData<String> = _text

    private val _ageData = MutableLiveData<Int>()
    val ageeData: LiveData<Int> = _ageData

    private val _mediatiorLiveData = MediatorLiveData<DataLive>()
    val mediatorLiveData: LiveData<DataLive> = _mediatiorLiveData

    init {
        checkCorotuine()
     _mediatiorLiveData.addSource(_nameData){
         val data=DataLive(name = it.toString(), age = 0)
         _mediatiorLiveData.value=data
     }
        _mediatiorLiveData.addSource(_ageData){
           val data=DataLive(name = "", age = it)
            _mediatiorLiveData.value=data
        }
    }

    private fun checkCorotuine()
    {

        viewModelScope.launch {

            val job1=launch {
                   try {
                       throw Exception("Error")
                   }
                   catch (e:Exception)
                   {
                       cancel()
                       Log.e("Child","0 ${this.coroutineContext} ")
                   }
               }
            Log.e("Child","0 ${job1.isActive} ")
           val job2= launch {
                Log.e("Child","1 ${this.coroutineContext}")
            }
           val job3= launch {
                Log.e("Child","2 ${this.coroutineContext}")
            }

        }

    }

    private fun checkCorotuineOne() {
        runBlocking {
            launch {
            try {
                throw Exception("Issue")
            } catch (e: Exception) {
                Log.e("Issue", "${e.printStackTrace()}")
            }
        }
        }
    }
    fun updateData(name:String,age:Int)
    {
        _nameData.value=name
        _ageData.value=age
    }
}