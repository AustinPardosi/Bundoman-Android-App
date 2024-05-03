package com.example.bundoman.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TransactionDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: TransactionEntity)

    @Update
    suspend fun updateTransaction(transaction: TransactionEntity)

    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)

    @Query("SELECT * FROM transactions ORDER BY date DESC")
    fun getAllTransaction(): LiveData<List<TransactionEntity>>

    @Query("SELECT * FROM transactions ORDER BY date DESC")
    fun getAllTransactionAsList(): List<TransactionEntity>

    @Query("SELECT * FROM transactions WHERE id = :id")
    fun getTransaction(id: Int): TransactionEntity

    @Query("DELETE FROM transactions WHERE id = :id")
    fun deleteTransactionWithId(id : Int)
}
