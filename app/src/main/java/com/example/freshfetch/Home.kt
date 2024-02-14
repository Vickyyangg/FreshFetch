package com.example.freshfetch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class Home : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList:Array<String>
    lateinit var priceList:Array<String>
    lateinit var descriptionList:Array<String>
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<DataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var paymentBtn= findViewById<ImageView>(R.id.imgPayment)
        paymentBtn.setOnClickListener{
            val intent = Intent(this, Payment::class.java)
            startActivity(intent)
        }

        imageList = arrayOf(
            R.drawable.tomato,
            R.drawable.grape,
            R.drawable.cucumber,
            )

        titleList = arrayOf(
            "Tomato",
            "Grape",
            "Cucumber"

        )
        priceList = arrayOf(
            "$4",
            "$5.5",
            "$5"
        )
        descriptionList = arrayOf(
            "Imported from organic farm",
            "Imported freshly from Local Farms",
            "Fresh and Crunchy Cucumber"
        )

        recyclerView = findViewById (R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        searchList = arrayListOf<DataClass>()
        getData()

        searchView.clearFocus()
       searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
           override fun onQueryTextSubmit(query: String?): Boolean {
               searchView.clearFocus()
               return true
           }

           override fun onQueryTextChange(newText: String?): Boolean {

               searchList.clear()
               val searchText = newText!!.toLowerCase(Locale.getDefault())
               if (searchText.isNotEmpty()) {
                   dataList.forEach {
                       if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)){
                           searchList.add(it)
                   }
               }
               recyclerView.adapter!!.notifyDataSetChanged()


           } else
           {
               searchList.clear()
               searchList.addAll(dataList)
               recyclerView.adapter!!.notifyDataSetChanged()
           }
           return false
       }
       })
    }

    private fun getData(){
        for(i in imageList.indices){
            val dataClass = DataClass(imageList[i],titleList[i],priceList[i],descriptionList[i])
            dataList.add(dataClass)

        }
        searchList.addAll(dataList)
        recyclerView.adapter = AdapterClass(searchList)
    }






}
