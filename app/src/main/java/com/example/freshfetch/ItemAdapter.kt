package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val ListItem:ArrayList<Items>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.itemName)
        val description: TextView = view.findViewById(R.id.item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlist,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = this.ListItem.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemName.text = ListItem[position].name
        ListItem[position].descripton.also { holder.itemName.text = it }

    }
}