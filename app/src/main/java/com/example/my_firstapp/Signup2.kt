package com.example.my_firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Signup2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)
        //find the ids
        var email:CheckBox=findViewById(R.id.email)
        var whatsapp:CheckBox=findViewById(R.id.whatsapp)
        var phone:CheckBox=findViewById(R.id.phone_call)

//        gender
        var male:RadioButton=findViewById(R.id.male)
        var female:RadioButton=findViewById(R.id.female)
        var custom:RadioButton=findViewById(R.id.custom)
        var signup2:Button=findViewById(R.id.signup2)
        signup2.setOnClickListener {
            Alert_Dialog()
        }
        //spinner
        val spinner=findViewById<Spinner>(R.id.spinner)
        //create a list of items to be displayed as dropdown menu
        var listitems= listOf<String>("Instagram","X","Facebook","LinkedIn")
        var array_Adapter=ArrayAdapter(this,
            android.R.layout.simple_spinner_item,listitems)
        array_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=array_Adapter
        //check the select item
        spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val selected_item=parent?.getItemIdAtPosition(position)
                Toast.makeText(applicationContext,"Selected item " +
                        "${listitems[position]}",Toast.LENGTH_LONG).show()
               // TODO("Not yet implemented")
            }//end of onItemSelected
            //Nothing selected
            override fun onNothingSelected(p0: AdapterView<*>?) {
                //TODO("Not yet implemented")
            }
        }
    }
    //create an alert dialogbox function
    private fun Alert_Dialog(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Confirm SignUp")
            .setMessage("Do you want to submit above details?")
            .setPositiveButton("Yes"){dialog,which->
                Toast.makeText(applicationContext,"SignUp Successful",
                    Toast.LENGTH_LONG).show()
                val x=Intent(applicationContext,Login::class.java)
                startActivity(x)
            }
            .setNegativeButton("No"){dialog,which->
                dialog.dismiss()
            }
        //display the alert dialog
        val alertDialog: AlertDialog=builder.create()
        alertDialog.show()
    }
}