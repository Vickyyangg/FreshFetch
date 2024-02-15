package com.example.freshfetch

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshfetch.databinding.ActivityHomeBinding


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
        val sellerPic: Int
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
            parcel.readInt()
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
            parcel.writeInt(sellerPic)
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //delivery btn
       binding.deliveryButton.setOnClickListener {
            val deliveryIntent = Intent(this@Home, Delivery::class.java)
            startActivity(deliveryIntent)
        }

        //payment
        binding.btnPayment.setOnClickListener {
            val intent = Intent(this@Home, Payment::class.java)
            startActivity(intent)
        }



        //item list
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val itemList = mutableListOf(
            Item(1, R.drawable.rice_card, "Best Rice", "Best Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$19", "Aimer", "0921183204", "BangNa", R.drawable.rounded_profile),
            Item(2, R.drawable.purerice, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Milet", "0823924248", "BangKapi", R.drawable.milet),
            Item(3, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Yoasobi", "0834238249", "Samui", R.drawable.lilas),
            Item(4, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Tomoo", "0938323893", "BangWa", R.drawable.tomoo),
            Item(5, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Nao", "0928842739", "Bangkok", R.drawable.rounded_profile),
            Item(6, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29", "Nao", "0928842739", "Bangkok",R.drawable.rounded_profile),
            Item(7, R.drawable.rice_card, "Pure Rice", "Pure Rice is a versatile staple known for its neutral flavor and essential role in global cuisines.", "$29","Aimer", "0921183204", "BangNa", R.drawable.rounded_profile)
        )

        val adapter = MyAdapter(this, itemList)
        binding.recyclerView.adapter = adapter
    }
}