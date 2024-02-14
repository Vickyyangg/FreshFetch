package com.example.freshfetch

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshfetch.databinding.ActivityHomeBinding
import android.os.Parcel
import android.os.Parcelable

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    data class Item(
        val id: Int,
        val imageResId: Int,
        val title: String,
        val description: String,
        val price: String,
        val seller: String,
        val sellerNo: String,
        val sellerAdr: String,
    ) : Parcelable {

        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?:"",
            parcel.readString() ?:"",
            parcel.readString() ?:"",
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(id)
            parcel.writeInt(imageResId)
            parcel.writeString(title)
            parcel.writeString(description)
            parcel.writeString(price)
            parcel.writeString(seller)
            parcel.writeString(sellerNo)
            parcel.writeString(sellerAdr)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Item> {
            override fun createFromParcel(parcel: Parcel): Item {
                return Item(parcel)
            }

            override fun newArray(size: Int): Array<Item?> {
                return arrayOfNulls(size)
            }
        }

    }

    companion object {
        val itemList = mutableListOf(
            Item(1, R.drawable.rice_card, "Best Rice", "Best Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$19","Aimer", "0823423323","Bang Na"),
            // ... (add other items)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //serchview trigger to make features buttons disappear
        binding.searchView.setOnQueryTextFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Show the featuresLayout when SearchView gains focus
                binding.featuresBtn.visibility = View.VISIBLE
            } else {
                // Hide the featuresLayout when SearchView loses focus
                binding.featuresBtn.visibility = View.GONE
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val itemList = mutableListOf(
            Item(1, R.drawable.rice_card, "Best Rice", "Best Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$19", "Aimer", "0921183204", "BangNa"),
            Item(2, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Milet", "0823924248", "BangKapi"),
            Item(3, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Yoasobi", "0834238249", "Samui"),
            Item(4, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Tomoo", "0938323893", "BangWa"),
            Item(5, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Nao", "0928842739", "Bangkok"),
            Item(6,R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Nao", "0928842739", "Bangkok"),
            Item(7,R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29","Aimer", "0921183204", "BangNa")
        )

        val adapter = MyAdapter(this, itemList)
        binding.recyclerView.adapter = adapter
    }



}