package com.example.freshfetch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.loginButton)
        val createAccountButton: Button = findViewById(R.id.createAccountButton)

        loginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                // Start the LoginActivity when the login button is clicked
                val loginIntent = Intent(this@MainActivity, Login::class.java)
                startActivity(loginIntent)
            }
        })

        createAccountButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                // Start the SignupActivity when the create account button is clicked
                val signupIntent = Intent(this@MainActivity, SignUp::class.java)
                startActivity(signupIntent)
            }
        })
    }
}