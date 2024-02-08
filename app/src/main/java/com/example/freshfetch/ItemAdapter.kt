package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshfetch.databinding.ItemlistBinding

class ItemAdapter(private val ListItem:ArrayList<Items>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = this.ListItem.size

    class ItemViewHolder(private val binding: ItemlistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Items) {
            binding.itemName.text = item.name
            binding.itemDescription.text = item.description
        }
}
