package com.example.freshfetch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.freshfetch.databinding.ActivityPaymentBinding

class Payment : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.payNow.setOnClickListener {
            val intent = Intent(this@Payment, Home::class.java)
            Toast.makeText(this@Payment, "Payment Successful!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}
