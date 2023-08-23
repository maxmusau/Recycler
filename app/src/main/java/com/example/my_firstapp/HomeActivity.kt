package com.example.my_firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //find the recyler view
        val recyclerView:RecyclerView=findViewById<RecyclerView>(R.id.recyclerview)
        val adapter=ItemAdapter(Conference_dataset()) //pass the dataset into the adapter
        recyclerView.adapter=adapter //define the adapter fro the recycler view
        recyclerView.layoutManager=LinearLayoutManager(applicationContext)
    }
    //create a function that contains the dataset
    private fun Conference_dataset():List<Item>{
        val list_items= listOf(
            Item(R.drawable.room1,"Large Board Rooms",
                "A large conference room for many people","5000",
                "50000","Available"),
            Item(R.drawable.room2,"Stylish conference Rooms",
            "A large conference room for many people","5000",
            "80000","Not Available"),
            Item(R.drawable.room3,"Creative conference Rooms",
                "A large conference room for many people","5000",
                "70000","Available"),
            Item(R.drawable.room4,"Small space Rooms",
                "A large conference room for many people","5000",
                "40000","Not Available"),
            Item(R.drawable.room5,"Open Space rooms",
                "A large conference room for many people","5000",
                "90000","Available")
        )
        return list_items
    }
}