package com.example.freshfetch

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.freshfetch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                // Start the LoginActivity when the login button is clicked
                val loginIntent = Intent(this@MainActivity, Login::class.java)
                startActivity(loginIntent)
            }
        })

        binding.createAccountButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                // Start the SignupActivity when the create account button is clicked
                val signupIntent = Intent(this@MainActivity, SignUp::class.java)
                startActivity(signupIntent)
            }
        })
    }
}
