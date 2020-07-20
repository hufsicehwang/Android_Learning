package com.example.class_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_sign__up.*

class login_page : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
// ...
// Initialize Firebase Auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        auth = FirebaseAuth.getInstance()
        //val btnlogin : Button = findViewById(R.id.btn_login)
        btn_login.setOnClickListener {
            btn_login.setText("로그인 중 입니다.")
            auth.signInWithEmailAndPassword(email_login.text.toString(), password_login.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        startActivity(Intent(this, home::class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "사용자 정보가 일치 하지 않습니다.", Toast.LENGTH_LONG).show()
                        // ...
                    }

                    // ...
                }
        }
    }

   // val intent = Intent(this, MainActivity::class.java)
    //intent.putExtra("HWang",7)
   // startActivity(intent)
}

