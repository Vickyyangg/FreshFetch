package com.example.freshfetch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshfetch.databinding.ActivityCartBinding

class Cart : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private val cartItemList = mutableListOf<Home.Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cartAdapter = CartAdapter(cartItemList)
        binding.recyclerView.adapter = cartAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        binding.removeBtn.setOnClickListener {
            // Clear the list of items
            cartItemList.clear()
            cartAdapter.notifyDataSetChanged()
            updateSubtotalAndTotal()
            Toast.makeText(this, "All items removed", Toast.LENGTH_SHORT).show()
        }

        binding.backButton.setOnClickListener {
            val intent = Intent(this@Cart, ItemDetail::class.java)
            startActivity(intent)
        }

        binding.checkoutBtn.setOnClickListener {
            val intent = Intent(this@Cart, Payment::class.java)
            startActivity(intent)
        }



        // Receive selected item from Intent
        val selectedItem: Home.Item? = intent.getParcelableExtra("SELECTED_ITEM")

        // If the selected item is not null, add it to the cartItemList
        selectedItem?.let {
            cartItemList.add(it)
        }

        // Set up RecyclerView and adapter
        val adapter = CartAdapter(cartItemList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun calculateSubtotal(): Double {
        return cartItemList.sumByDouble { it.price.toDouble() }
    }

    private fun calculateTotal(): Double {
        return calculateSubtotal()
    }

    private fun updateSubtotalAndTotal() {
        val subtotal = calculateSubtotal()
        val total = calculateTotal()

        binding.subTotal.text = "Sub-total: $subtotal"
        binding.totalAmount.text = "Total: $total"
    }
}

