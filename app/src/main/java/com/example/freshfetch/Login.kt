package com.example.freshfetch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.freshfetch.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //back button logic
        binding.backButton.setOnClickListener {
            val goBack = Intent(this@Login, MainActivity::class.java)
            startActivity(goBack)
        }

        binding.btnLogin.setOnClickListener {
            // Start the Home activity when the Sign Up button is clicked
            val intent = Intent(this@Login, Home::class.java)
            startActivity(intent)
        }

        binding.BSU.setOnClickListener {
            // Start the Home activity when the Sign Up button is clicked
            val intent = Intent(this@Login, SignUp::class.java)
            startActivity(intent)
        }


    }
}