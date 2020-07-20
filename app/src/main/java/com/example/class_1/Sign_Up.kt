package com.example.class_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign__up.*

class Sign_Up : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    // ...
// Initialize Firebase Auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign__up)
        auth = FirebaseAuth.getInstance()
        btn_signup.setOnClickListener {
            btn_signup.setText("SIGNING...")
            if (email.text.toString().length <= 0 || password.text.toString().length <= 0) {
                Toast.makeText(this, "이메일과 패스워드를 기입해 주세요.", Toast.LENGTH_LONG).show()
            } else {
                auth.createUserWithEmailAndPassword(email.text.toString(), password.text.
                toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success")
                            val user = auth.currentUser
                            //updateUI(user)
                        } else {
                            startActivity(Intent(this, login_page::class.java))
                            // If sign in fails, display a message to the user.

                        }

                        // ...
                    }
            }
        }
    }
}