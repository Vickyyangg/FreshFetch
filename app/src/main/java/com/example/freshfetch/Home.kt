package com.example.freshfetch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshfetch.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    data class Item(val imageResId: Int, val title: String, val description: String, val price: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        val itemList = mutableListOf(
            Item(R.drawable.rice_card, "Best Rice", "Best Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$19"),
            Item(R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29"),
        )

        val adapter = MyAdapter(this, itemList)
        binding.recyclerView.adapter = adapter
    }
}