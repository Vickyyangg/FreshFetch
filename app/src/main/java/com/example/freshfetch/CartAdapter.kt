package com.example.freshfetch
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshfetch.databinding.CartCardBinding
import com.example.freshfetch.Home.Item

class CartAdapter(private val cartItemList: List<Item>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CartCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cartItemList[position]

        // Set data to the views
        holder.binding.image.setImageResource(item.imageResId)
        holder.binding.title.text = item.title
        holder.binding.checkoutPrice.text = item.price
    }

    override fun getItemCount(): Int {
        return cartItemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: CartCardBinding = CartCardBinding.bind(itemView)
    }
}
