package com.example.freshfetch

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.freshfetch.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //back button logic
        binding.backButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                // goBack to Initial page when the back button is clicked
                val goBack = Intent(this@Login, MainActivity::class.java)
                startActivity(goBack)
            }
        })
    }
}
