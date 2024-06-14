package com.example.shadiclonecom.helper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shadiclonecom.dao.ExpenseDao
import com.example.shadiclonecom.entity.Expense


@Database(entities=[Expense::class] , exportSchema = false, version = 1)
abstract class DataBaseHelper: RoomDatabase() {



     abstract fun expenseDao(): ExpenseDao

companion object {
    private  val DB_NAME: String = "expensedb"
    @Volatile
    var instance: DataBaseHelper?=null
    fun getDB(context: Context): DataBaseHelper ?{
        if (instance == null) {
            synchronized(DataBaseHelper::class.java) {
                if (instance == null) {
                    instance =Room.databaseBuilder(context,DataBaseHelper::class.java, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }
            }
        }
        return instance


    }
}


        }



