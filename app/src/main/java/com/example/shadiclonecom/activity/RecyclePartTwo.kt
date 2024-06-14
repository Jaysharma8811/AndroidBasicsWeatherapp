package com.example.shadiclonecom.activity

import com.example.shadiclonecom.adapter.RecyleAdapterPartTwo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shadiclonecom.R
import com.example.shadiclonecom.dataclasses.RecycleDataPartTwo

class RecyclePartTwo : AppCompatActivity() {
    val data=ArrayList<RecycleDataPartTwo>()
    lateinit var recyclerview:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_part_two)
        recyclerview=findViewById(R.id.recyclerViewPartTwo)
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Ram","perfect"))
        data.add(RecycleDataPartTwo("shyam","love"))
        data.add(RecycleDataPartTwo("kripa","Joyful"))
        data.add(RecycleDataPartTwo("amit","angry"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))
        data.add(RecycleDataPartTwo("Rahul","Joyful"))

        recyclerview.layoutManager=LinearLayoutManager(this)
          recyclerview.adapter= RecyleAdapterPartTwo(data)
    }
}