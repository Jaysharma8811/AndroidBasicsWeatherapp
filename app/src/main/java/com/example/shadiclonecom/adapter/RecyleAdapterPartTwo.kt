package com.example.shadiclonecom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shadiclonecom.R
import com.example.shadiclonecom.dataclasses.RecycleDataPartTwo

//class RecyleAdapterPartTwo (val mlist:List<RecycleDataPartTwo>):RecyclerView.Adapter<RecyleAdapterPartTwo.MyViewHolder>(){
//    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//
//        var textname:TextView=itemView.findViewById(R.id.nameparttwo)
//        var texttype:TextView=itemView.findViewById(R.id.typeparttwo)
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.prac_item_list,parent,false)
//        return MyViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//       return mlist.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.textname.text=mlist[position].name
//        holder.texttype.text=mlist[position].type


//    }
//}

class  RecyleAdapterPartTwo(val mList:List<RecycleDataPartTwo>):RecyclerView.Adapter<RecyleAdapterPartTwo.MyViewHolder>(){
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var txtName:TextView=itemView.findViewById(R.id.nameparttwo)
        var txtType:TextView=itemView.findViewById(R.id.typeparttwo)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view:View=LayoutInflater.from(parent.context).inflate(R.layout.prac_item_list,parent,false)
            return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtName.text=mList[position].name
        holder.txtType.text=mList[position].type

    }

}