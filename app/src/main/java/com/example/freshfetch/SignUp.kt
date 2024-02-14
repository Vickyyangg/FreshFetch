package com.example.freshfetch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.freshfetch.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BSI.setOnClickListener {
            val intent = Intent(this@SignUp, Login::class.java)
            startActivity(intent)
        }

        //back button logic
        binding.backButton.setOnClickListener {
            val goBack = Intent(this@SignUp, MainActivity::class.java)
            startActivity(goBack)
        }

    }
}