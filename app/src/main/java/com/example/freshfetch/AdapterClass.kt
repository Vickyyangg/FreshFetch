package com.example.freshfetch

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class AdapterClass(private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>(){
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvimage:ImageView = itemView.findViewById(R.id.image)
        val rtTitle:TextView = itemView.findViewById(R.id.title)
    }
}
