package com.example.my_firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        //find the ids
        var username=findViewById<EditText>(R.id.username)
        var password =findViewById<EditText>(R.id.password)
        var confirm =findViewById<EditText>(R.id.confirm_pass)
        var signup =findViewById<Button>(R.id.signup)

        var login =findViewById<TextView>(R.id.login)
        signup.setOnClickListener {
            Toast.makeText(applicationContext,
                "Go to Signup2", Toast.LENGTH_LONG).show()
            var x=Intent(applicationContext,Signup2::class.java)
            startActivity(x)
        }
        login.setOnClickListener {
            Toast.makeText(applicationContext,
                "Go to Signup2 Page", Toast.LENGTH_LONG).show()
            var x=Intent(applicationContext,Login::class.java)
            startActivity(x)
        }


    }

}