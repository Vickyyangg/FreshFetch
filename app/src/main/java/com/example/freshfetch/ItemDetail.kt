package com.example.freshfetch

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.freshfetch.databinding.ActivityItemDetailBinding

class ItemDetail : AppCompatActivity() {
    private lateinit var binding: ActivityItemDetailBinding
    private lateinit var itemList: List<Home.Item>
    private var selectedItemPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val goBack = Intent(
                this@ItemDetail, Home::class.java
            )
            startActivity(goBack)
        }

        itemList = intent.getParcelableArrayListExtra("ITEM_LIST") ?: emptyList()
        selectedItemPosition = intent.getIntExtra("ITEM_POSITION", -1)

        if (selectedItemPosition != -1 && selectedItemPosition < itemList.size) {
            // Fetch selected item from the list
            val selectedItem = itemList[selectedItemPosition]

            updateUI(selectedItem)
        } else {
            // Handle the case where the item position is invalid
            // TODO: Handle this case, maybe show an error message or go back to the previous screen
        }
    }

    private fun updateUI(selectedItem: Home.Item) {
        binding.itemImage.setImageResource(selectedItem.imageResId)
        binding.itemName.text = selectedItem.title
        binding.itemDescription.text = selectedItem.description
        binding.itemPrice.text = selectedItem.price
        binding.sellerName.text = selectedItem.seller
        binding.sellerPhone.text = selectedItem.sellerNo
        binding.sellerAddress.text = selectedItem.sellerAdr
        binding.sellerProfileIcon.setImageResource(selectedItem.sellerPic)
    }
}
