package com.zebdul.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textView:TextView  //initialize variables for late use
    private lateinit var imageView:ImageView
    private lateinit var string1:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)  //find by id
        textView = findViewById(R.id.textView)
        imageView.setOnClickListener {   //set an clickListener
            whatsappShare()   //call a function for setClickListener
        }    }
    private fun whatsappShare() {
        try {  //implement fun in the try and catch because if whatsapp not installed on user phone
            val intent = Intent(Intent.ACTION_SEND)  // call a send intent
            intent.type = "text/plain" //tell which type of intent
            string1 = "Subscribe my channel" + "http://www.youtube.com/@zebdul3"
            // initialize string variable for text + url
            intent.putExtra(Intent.EXTRA_TEXT, string1) //put text for the share item
            intent.`package` = "com.whatsapp.w4b" //tell which application has to call
            startActivity(intent) // start activity for fun
        }catch (exp: Exception){ //add a toast message for if app not installed
            Toast.makeText(applicationContext, "Whatsapp not installed on your device",
                Toast.LENGTH_SHORT).show()
        }    }    }
