package com.example.my_firstapp
//this is the model
//the model contains dataset
//room_id, room_name,room_desc,num_people,cost,availability
data class Item(
    val room_id:Int,
    val image_url:String,
    val room_name:String,
    val room_desc:String,
    val num_of_people:String,
    val cost:String,
    val availability:String
)
