package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Delivery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)
        val items = arrayListOf(
            Items("Rice","Fresh rice imported directly from farm"),
            Items("Tomato","Fresh Tomatoes imported from organically planted farm"),
            Items("Cucumber","Fresh and Crunchy Cucumber"),
            Items("Grapes","Imported Freshly from Local farms"),
            Items("Lettuce","Fresh Lettuce imported from farms"),
            Items("Cherry","Directly picked and imported fresh")
        )
        val nameList = findViewById<RecyclerView>(R.id.itemLists)
        nameList.apply {
            layoutManager = LinearLayoutManager(this@Delivery)
            adapter = ItemAdapter(items)
        }

    }


}