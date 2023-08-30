package com.example.my_firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //find the ids
        var username=findViewById<EditText>(R.id.username)
        var password =findViewById<EditText>(R.id.password)
        var login =findViewById<Button>(R.id.login)
        var progress =findViewById<ProgressBar>(R.id.progressbar)
        progress.visibility=View.GONE

        var signup =findViewById<TextView>(R.id.signup)
        login.setOnClickListener {
            progress.visibility= View.VISIBLE
//            loopj-library to consume the api(http requests)
//            cretae http client
            val client= AsyncHttpClient(true,
                80,443)
//            body that holds the data requeired in the api(request)
            var body= JSONObject()
            //put the data provided by user into the body
            body.put("username",username.text.toString())
            body.put("password",password.text.toString())
            val con_body= StringEntity(body.toString())
//            define the http method to use
            client.post(this,
                "https://sofwaredev.pythonanywhere.com/signin",
                con_body,"application/json",
                object : JsonHttpResponseHandler() {
                    //onsuccess function
                    override fun onSuccess(
                        statusCode: Int,
                        headers: Array<out Header>?,
                        response: JSONObject?
                    ) {
//                    check if the status code is 200
                        if (statusCode == 201){
                            Toast.makeText(applicationContext, "Signin Successful"+statusCode,
                                Toast.LENGTH_SHORT).show()
//                        intent to the signin activity
                            val x=Intent(applicationContext,MainActivity::class.java)
                            startActivity(x)
                        }//end of if
                        else{
                            progress.visibility= View.GONE
                            Toast.makeText(applicationContext,
                                "Failed. Please try again"+statusCode,
                                Toast.LENGTH_SHORT).show()
                        }
                    } //end of onsuccess

                    override fun onFailure(
                        statusCode: Int,
                        headers: Array<out Header>?,
                        throwable: Throwable?,
                        errorResponse: JSONObject?
                    ) {
                        //hide the progressbar
                        progress.visibility= View.GONE
                        Toast.makeText(applicationContext,
                            "Something went Wrong", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }




        signup.setOnClickListener {
            Toast.makeText(applicationContext,
                "Go to Login", Toast.LENGTH_LONG).show()
            var x=Intent(applicationContext,Signup::class.java)
            startActivity(x)
        }
    }
}