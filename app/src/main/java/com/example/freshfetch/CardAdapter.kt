package com.example.freshfetch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshfetch.databinding.ItemCardBinding
import com.example.freshfetch.Home.Item

class MyAdapter(private val context: Context, private val itemList: List<Item>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        // Set data to the views
        holder.binding.itemImageView.setImageResource(item.imageResId)
        holder.binding.itemTitleTextView.text = item.title
        holder.binding.itemDescriptionTextView.text = item.description
        holder.binding.itemPriceTextView.text = item.price



        holder.itemView.setOnClickListener {
            val intent = Intent(context, ItemDetail::class.java)
            intent.putExtra("ITEM_LIST", ArrayList(itemList)) // this Pass the whole item list
            intent.putExtra("ITEM_POSITION", position) // this Pass the position of the clicked item
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemCardBinding = ItemCardBinding.bind(itemView)
    }
}
