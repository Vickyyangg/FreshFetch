package com.example.freshfetch

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.freshfetch.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val goBack = Intent(this@Login, MainActivity::class.java)
            startActivity(goBack)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.usernameInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()

            val correctUsername = "ana"
            val correctPassword = "heehee"

            if (username == correctUsername && password == correctPassword) {
                // Successful login
                showToast("Login successful!")
                val intent = Intent(this@Login, Home::class.java)
                startActivity(intent)

                // Close the keyboard
                hideKeyboard()
            } else {
                // Failed login
                hideKeyboard()
                showToast("Invalid username or password")
            }
        }

        binding.BSU.setOnClickListener {
            val intent = Intent(this@Login, SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}
