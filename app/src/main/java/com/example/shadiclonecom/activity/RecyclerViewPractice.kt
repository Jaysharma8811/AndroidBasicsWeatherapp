package com.example.shadiclonecom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shadiclonecom.R
import com.example.shadiclonecom.dataclasses.RecyclerData
import com.example.shadiclonecom.adapter.RecyclerAdapter

class RecyclerViewPractice : AppCompatActivity() {
    val data = ArrayList<RecyclerData>()
   lateinit var  recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_practice)
        recyclerView=findViewById(R.id.recyclerView)

       data.add(RecyclerData("Durgesh","Andriod Developer"))
        data.add(RecyclerData("Vineet","Mobile Application Developer"))
        data.add(RecyclerData("Jay","Flutter Developer"))
        data.add(RecyclerData("Durgesh","Andriod Developer"))
        data.add(RecyclerData("Vineet","Mobile Application Developer"))
        data.add(RecyclerData("Jay","Flutter Developer"))
        data.add(RecyclerData("Durgesh","Andriod Developer"))
        data.add(RecyclerData("Vineet","Mobile Application Developer"))
        data.add(RecyclerData("Jay","Flutter Developer"))
        data.add(RecyclerData("Durgesh","Andriod Developer"))
        data.add(RecyclerData("Vineet","Mobile Application Developer"))
        data.add(RecyclerData("Jay","Flutter Developer"))
        data.add(RecyclerData("Durgesh","Andriod Developer"))
        data.add(RecyclerData("Vineet","Mobile Application Developer"))
        data.add(RecyclerData("Jay","Flutter Developer"))

        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter= RecyclerAdapter(data)

    }
}