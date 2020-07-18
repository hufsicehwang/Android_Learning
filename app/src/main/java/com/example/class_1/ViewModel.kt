package com.example.class_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class data(
    val title:String?="",
    val descripton:String?=""
){}
class MyViewmodel: ViewModel(){
    val list= ArrayList<data>()
    val Livedata = MutableLiveData<ArrayList<data>>()            //livedata 형식
    val j = 80
    fun mydata(){
        list.clear()
        for(i in 0 until 10){
            // 데이터를 스트링으로 바꿀려면 어떻게 해야할까?
            val data = data("김준영의 마음" + (i+j), "이우림의 마음" + i)
            list.add(data)

        }
        Livedata.value = list          // 형식 연동 느낌
    }
}
