package com.example.my_firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        access the card ids
        var home =findViewById<CardView>(R.id.home)
        var profile =findViewById<CardView>(R.id.profile)
        var create =findViewById<CardView>(R.id.create)
        var settings =findViewById<CardView>(R.id.settings)
        var search =findViewById<CardView>(R.id.search)
        var more =findViewById<CardView>(R.id.more)
//        define some functionality
        home.setOnClickListener {
            Toast.makeText(applicationContext,
                "Go to Login page",Toast.LENGTH_LONG).show()
            //intent kotlin activities
            var x=Intent(applicationContext,HomeActivity::class.java)
            startActivity(x)
        }//end of home clicklistener
        profile.setOnClickListener {
            Toast.makeText(applicationContext,
                "Profile Card Clicked",Toast.LENGTH_LONG).show()
        }
        search.setOnClickListener {
            Toast.makeText(applicationContext,
                "Search Card Clicked",Toast.LENGTH_LONG).show()
        }
        more.setOnClickListener {
            Toast.makeText(applicationContext,
                "More Card Clicked",Toast.LENGTH_LONG).show()
        }
        settings.setOnClickListener {
            Toast.makeText(applicationContext,
                "Settings Card Clicked",Toast.LENGTH_LONG).show()
        }
//sharedpreference
//        recyclerview
//        recyclerAdapter

    }

}