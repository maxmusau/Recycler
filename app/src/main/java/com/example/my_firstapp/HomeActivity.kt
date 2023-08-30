package com.example.my_firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONArray
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {
    //    initialize the recycler adapter
    private lateinit var adapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //find the recyler view
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val progress = findViewById<ProgressBar>(R.id.progressbar)
        adapter = ItemAdapter(applicationContext)
//        recyclerView.adapter = adapter //define the adapter fro the recycler view

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setHasFixedSize(true)

//            loopj-library to consume the api(http requests)
//            cretae http client
        val client = AsyncHttpClient(
            true,
            80, 443
        )
//            define the http method to use
        client.post(this,
            "https://sofwaredev.pythonanywhere.com/getconferencerooms",
            null, "application/json",
            object : JsonHttpResponseHandler() {
                //onsuccess function
                override fun onSuccess(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    response: JSONArray?
                ) {
                    //convert the jsonarray into list
                    val gson = GsonBuilder().create()
//                        create the list
                    val list = gson.fromJson(
                        response.toString(),
                        Array<Item>::class.java
                    ).toList()

//                        pass the converted list to the adapater
                    adapter.setConferenceItems(list)
                    progress.visibility=View.GONE

                } //end of onsuccess

                override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseString: String?,
                    throwable: Throwable?
                ) {
                    //hide the progressbar
                    progress.visibility = View.GONE
                    Toast.makeText(
                        applicationContext,
                        "Something went Wrong", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) //end of post
//        now put the adapter to recyclerview
        recyclerView.adapter=adapter
    }

    //create a function that contains the dataset


//    private fun Conference_dataset(): List<Item> {
////        api =https://sofwaredev.pythonanywhere.com/getconferencerooms
//        val list_items = listOf(
//            Item(
//                R.drawable.room1, "Large Board Rooms",
//                "A large conference room for many people", "5000",
//                "Ksh.50000", "Available"
//            ),
//            Item(
//                R.drawable.room2, "Stylish conference Rooms",
//                "A large conference room for many people", "5000",
//                "Ksh.80000", "Not Available"
//            ),
//            Item(
//                R.drawable.room3, "Creative conference Rooms",
//                "A large conference room for many people", "5000",
//                "Ksh.70000", "Available"
//            ),
//            Item(
//                R.drawable.room4, "Small space Rooms",
//                "A large conference room for many people", "5000",
//                "Ksh.40000", "Not Available"
//            ),
//            Item(
//                R.drawable.room5, "Open Space rooms",
//                "A large conference room for many people", "5000",
//                "Ksh.90000", "Available"
//            )
//        )
//        return list_items
//    }
}