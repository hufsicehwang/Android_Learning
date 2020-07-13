package com.example.class_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class data(
    val title:String?="",
    val descripton:String?=""
){}
class MyViewmodel: ViewModel(){
    val list= ArrayList<data>()
    val Livedata = MutableLiveData<ArrayList<data>>()
    fun mydata(){
        list.clear()
        for(i in 0 until 10){
            val data = data(""+i,""+i)
            list.add(data)
        }
        Livedata.value = list
    }
}
