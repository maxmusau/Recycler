package com.example.my_firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
    }
}