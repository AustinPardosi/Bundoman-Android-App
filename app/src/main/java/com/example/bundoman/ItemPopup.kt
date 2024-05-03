package com.example.bundoman

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bundoman.adapter.ItemAdapter
import com.example.bundoman.room.TransactionDatabase
import com.example.bundoman.room.TransactionEntity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemPopup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_bill)

        val bundle = intent.extras
        val itemNames = bundle?.getStringArrayList("itemNames")
        val itemQty = bundle?.getIntegerArrayList("itemQty")
        val itemPrice = bundle?.getDoubleArray("itemPrices")
        val itemAdapter = ItemAdapter(itemNames!!, itemQty!!, itemPrice!!.toTypedArray())

        val recyclerView: RecyclerView = findViewById(R.id.itemList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter

        val locationInput : TextInputEditText = findViewById(R.id.location_edit_text_scan)
        val categorySpinner: Spinner = findViewById(R.id.category_scan)
        ArrayAdapter.createFromResource(
            this,
            R.array.transaction_categories,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            categorySpinner.adapter = adapter
        }

        val ulangButton = findViewById<Button>(R.id.ulangBill)
        ulangButton.setOnClickListener {
            finish()
        }

        val saveBillButton = findViewById<Button>(R.id.simpanBill)
        saveBillButton.setOnClickListener {
            if (categorySpinner.isEmpty() || locationInput.text.toString().isEmpty()) {
                Toast.makeText(applicationContext, "Lokasi dan kategori tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Menyimpan transaksi",
                    Toast.LENGTH_SHORT
                ).show()
                var transactionTitle = ""
                var transactionValue = 0.0

                for (i in 0..<itemNames.size) {
                    transactionTitle += itemNames[i]
                    transactionValue += itemPrice[i] * itemQty[i]
                }
                val transactionEntity = TransactionEntity(
                    title = transactionTitle,
                    category = categorySpinner.selectedItem.toString(),
                    value = transactionValue,
                    location = locationInput.text.toString(),
                    latitude = LocManager.currentLatitude,
                    langitude = LocManager.currentLongitude,
                )
                // Save transactions into database
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        TransactionDatabase.getDatabase(applicationContext).transactionDAO.insertTransaction(
                            transactionEntity
                        )
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                applicationContext,
                                "Penyimpanan transaksi berhasil",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                applicationContext,
                                "Penyimpanan transaksi gagal : " + e.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val locationInput : TextInputEditText = findViewById(R.id.location_edit_text_scan)
        LocManager.checkLocationPermissionAndGetLocation(this,locationInput)
    }
}