package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshfetch.databinding.ActivityDeliveryBinding


class Delivery : AppCompatActivity() {
    private lateinit var binding: ActivityDeliveryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = arrayListOf(
            Items("Rice","Fresh rice imported directly from farm"),
            Items("Tomato","Fresh Tomatoes imported from organically planted farm"),
            Items("Cucumber","Fresh and Crunchy Cucumber"),
            Items("Grapes","Imported Freshly from Local farms"),
            Items("Lettuce","Fresh Lettuce imported from farms"),
            Items("Cherry","Directly picked and imported fresh")
        )
        val adapter = ItemAdapter(items)
        binding.itemLists.adapter = adapter
        binding.itemLists.layoutManager = LinearLayoutManager(this)
    }


}