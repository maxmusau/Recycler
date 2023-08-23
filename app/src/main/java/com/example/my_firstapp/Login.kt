package com.example.my_firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //find the ids
        var username=findViewById<EditText>(R.id.username)
        var password =findViewById<EditText>(R.id.password)
        var login =findViewById<Button>(R.id.login)

        var signup =findViewById<TextView>(R.id.signup)
        login.setOnClickListener {
            Toast.makeText(applicationContext,
                "Welcome $username",Toast.LENGTH_LONG).show()
            var x=Intent(applicationContext,MainActivity::class.java)
            startActivity(x)
        }
        signup.setOnClickListener {
            Toast.makeText(applicationContext,
                "Go to Login", Toast.LENGTH_LONG).show()
            var x=Intent(applicationContext,Signup::class.java)
            startActivity(x)
        }
    }
}