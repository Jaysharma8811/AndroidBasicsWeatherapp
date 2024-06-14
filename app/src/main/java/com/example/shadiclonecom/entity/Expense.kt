package com.example.shadiclonecom.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")

data class Expense(@ColumnInfo(name = "title") val title:String, @ColumnInfo(name = "amount")val amount:String,


                   @PrimaryKey(autoGenerate = true)
                   var id:Int=0

) 

{

                                                                                 }