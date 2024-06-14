package com.example.shadiclonecom.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shadiclonecom.R
import com.example.shadiclonecom.entity.Expense
import com.example.shadiclonecom.helper.DataBaseHelper

class RoomPractice : AppCompatActivity() {
    lateinit var edtTextTitle:EditText
    lateinit var edtTextExpense:EditText
    lateinit var  btnAdd:Button
        var dataBaseHelper:DataBaseHelper?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_room_practice)
//        val dataBaseHelper:DataBaseHelper= DataBaseHelper.
        dataBaseHelper=DataBaseHelper.getDB(this)












        

        edtTextTitle=findViewById(R.id.editTextTitle)
        edtTextExpense=findViewById(R.id.editTextExpense)
        btnAdd=findViewById(R.id.btnAddData)
        btnAdd.setOnClickListener {
             var title:String=edtTextTitle.getText().toString()
            var amount:String=edtTextExpense.getText().toString()
            dataBaseHelper?.expenseDao()?.addTx(Expense(title,amount))
//            var lst :List<Expense > =dataBaseHelper!!.expenseDao().getAllExpense()
//            var arrExpense:ArrayList<Expense> = dataBaseHelper?.expenseDao()?.getAllExpense() as ArrayList<Expense>
//            var i:Int=0
//            for (i in arrExpense){
//                Log.d("datatestt", lst[0].title.toString())
//
//        }
        }
    }


}