package com.example.shadiclonecom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shadiclonecom.R
import com.example.shadiclonecom.dataclasses.RecyclerData

class RecyclerAdapter(val mlist:List<RecyclerData>): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: TextView = itemView.findViewById(R.id.name)
        val textViewDesignation: TextView = itemView.findViewById(R.id.designation)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view:View= LayoutInflater.from(parent.context).inflate(R.layout.item_list_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewName.text = mlist[position].name.toString()
        holder.textViewDesignation.text = mlist[position].designation.toString()
    }
}