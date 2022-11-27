package com.android.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val fileName = "cars.json"
        val jsonString = application.assets.open(fileName).bufferedReader().use{
            it.readText()
        }
        val objectList = Gson().fromJson(jsonString, Array<Car>::class.java).asList()
        print(objectList)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CarsAdapter(objectList,this)
    }
}