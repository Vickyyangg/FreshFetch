package com.example.freshfetch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class AdapterClass(private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
    return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvimage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text= currentItem.dataTitle
        holder.rvDescription.text= currentItem.description
        holder.rvPrice.text= currentItem.price
    }
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvimage:ImageView = itemView.findViewById(R.id.image)
        val rvTitle:TextView = itemView.findViewById(R.id.title)
        val rvDescription:TextView = itemView.findViewById(R.id.description)
        val rvPrice: TextView = itemView.findViewById(R.id.price)
    }
}
