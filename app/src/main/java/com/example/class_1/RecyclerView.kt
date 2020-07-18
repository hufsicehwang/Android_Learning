package com.example.class_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity() {
    val viewModel:MyViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        lateinit var list: ArrayList<data>
        viewModel.mydata()

        val adapter = RecyclerAdapter(viewModel.list, LayoutInflater.from(this))
        recyler.adapter = adapter
        recyler.layoutManager = LinearLayoutManager(this)
        viewModel.Livedata.observe(this, Observer {  })
        // observe로 실시간 데이터 넣어줌 기억하자 잘 몰라도


    }


}

class RecyclerAdapter(                  // 존나 어렵다 viewholder라는 놈을 꼭 쓴단는걸 기억하자
    val list: ArrayList<data>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.text_title)
        val descripton = view.findViewById<TextView>(R.id.text_description)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.recycler_view2,parent,false))
    }

    override fun getItemCount(): Int {         // 크게 필요x
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {  // 리스트의 포지션 값마다 두 변수의 값 설정
        holder.title.setText(list[position].title)
        holder.descripton.setText(list[position].descripton)
    }
}