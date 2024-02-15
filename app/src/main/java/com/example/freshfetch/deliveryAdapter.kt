package com.example.freshfetch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshfetch.databinding.DeliveryCardBinding
class ItemAdapter(private val ListItem:ArrayList<Items>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DeliveryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Set data to the views
        val item = ListItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = this.ListItem.size

    class ItemViewHolder(private val binding: DeliveryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Items) {
            binding.itemName.text = item.name
            binding.itemDescription.text = item.description
            binding.itemPrice.text = item.price
            binding.imageView.setImageResource(item.image)
        }
    }
}