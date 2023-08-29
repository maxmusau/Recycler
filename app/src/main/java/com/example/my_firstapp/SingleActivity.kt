package com.example.my_firstapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        //get the sharedpref file
        val sharedpref:SharedPreferences=getSharedPreferences(
            "file",Context.MODE_PRIVATE)
        //access the ids
        //get image data from the sharedpref
        val image=sharedpref.getInt("img_url",0)
        var imageview=findViewById<ImageView>(R.id.image_url)
        Glide.with(applicationContext).load(image )
            .apply(RequestOptions().centerCrop()).into(imageview)

        var room_id=findViewById<TextView>(R.id.room_id)
        //get room_name data from the sharedpref
        val name=sharedpref.getString("room_name","")
        var room_name=findViewById<TextView>(R.id.room_name)
        room_name.text=name

        var room_des=findViewById<TextView>(R.id.room_desc)

        val room_cost=sharedpref.getString("cost","")
        var cost=findViewById<TextView>(R.id.cost)
        cost.text=room_cost

        val status=sharedpref.getString("availability","")
        var availability=findViewById<TextView>(R.id.availability)
        availability.text=status

        var num_of_people=findViewById<TextView>(R.id.num_of_persons)

        //mpesa payment
        val phone:EditText=findViewById(R.id.phone)
        val cost_room:EditText=findViewById(R.id.room_cost)
        val book:Button=findViewById(R.id.book)
//        api https://sofwaredev.pythonanywhere.com/mpesa_payment

    }
}