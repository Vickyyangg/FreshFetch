package com.example.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshfetch.databinding.ItemlistBinding

class ItemAdapter(private val ListItem:ArrayList<Items>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    var OnItemClick : ((Items) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = ListItem[position]
        holder.bind(item)

        holder.itemView.setOnClickListener{
            OnItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int = this.ListItem.size

    class ItemViewHolder(private val binding: ItemlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //Binding the id with data from itemlist.xml
        fun bind(item: Items) {
            binding.itemName.text = item.name
            binding.itemDescription.text = item.description
            binding.itemPrice.text = item.price
            binding.imageView.setImageResource(item.image)
        }
    }
}
