package com.example.freshfetch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.freshfetch.databinding.ActivityItemDetailBinding
import com.example.project.Items

class ItemDetail : AppCompatActivity() {
    private lateinit var binding: ActivityItemDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val item = intent.getParcelableExtra<Items>("selectedItem")
        if (item != null){
            val imageView: ImageView = findViewById(R.id.DetailedImage)
            val textView: TextView = binding.DetailitemName
            val textView1: TextView = binding.DetailitemPrice
            val textView2: TextView = binding.DetailitemDescription

            textView.text = item.name
            textView1.text = item.price
            textView2.text = item.description
            imageView.setImageResource(item.image)
        }
    }
}