package com.example.shadiclonecom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.shadiclonecom.entity.Expense

@Dao
interface ExpenseDao {

    @Query("select * from expense")
    fun getAllExpense():List<Expense>

    @Insert
    fun addTx(expense: Expense)

    @Update
    fun updateTxt(expense: Expense)
    @Delete
    fun deleteTx(expense: Expense)
}