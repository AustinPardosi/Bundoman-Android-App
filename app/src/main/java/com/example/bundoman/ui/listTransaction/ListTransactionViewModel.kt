package com.example.bundoman.ui.listTransaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bundoman.repository.TransactionRepository
import com.example.bundoman.room.TransactionEntity
import kotlinx.coroutines.launch

class ListTransactionViewModel(private val repository: TransactionRepository): ViewModel()  {
    val allTransactions: LiveData<List<TransactionEntity>> = repository.listTransaction

    fun insertTransaction(transaction: TransactionEntity) = viewModelScope.launch {
        repository.insertTransaction(transaction)
    }

    fun updateTransaction(transaction: TransactionEntity) = viewModelScope.launch {
        repository.updateTransaction(transaction)
    }

    fun deleteTransaction(transaction: TransactionEntity) = viewModelScope.launch {
        repository.deleteTransaction(transaction)
    }

}