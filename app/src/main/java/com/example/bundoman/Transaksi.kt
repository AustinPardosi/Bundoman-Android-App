package com.example.bundoman

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bundoman.room.TransactionDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar
import java.util.Date

class Transaksi : Fragment() {
    val calendar = Calendar.getInstance()
    val date: Date
    lateinit var recyclerView: RecyclerView

    init {
        calendar.set(2024, 2, 18)
        date = calendar.time
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaksi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addButton: FloatingActionButton = view.findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val intent = Intent(requireContext(), AddTransaksiActivity::class.java)
            startActivity(intent)
        }

        recyclerView = view.findViewById(R.id.recyclerView)
    }

    override fun onResume() {
        super.onResume()
        val transactionList = TransactionDatabase.getDatabase(requireContext()).transactionDAO.getAllTransactionAsList()
        val myAdapter = MyAdapter(transactionList, requireContext())

        // Set layout manager and adapter to recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = myAdapter
    }
}
