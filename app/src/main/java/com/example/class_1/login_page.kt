package com.example.class_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login_page.*

class login_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        //val btnlogin : Button = findViewById(R.id.btn_login)
        btn_login.setOnClickListener {
            btn_login.setText("로그인 중 입니다.")
        }
    }
}