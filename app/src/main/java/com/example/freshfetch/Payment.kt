package com.example.freshfetch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

       var backBtn = findViewById<ImageView>(R.id.backbtn)
        backBtn.setOnClickListener{
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
        }

    }
}