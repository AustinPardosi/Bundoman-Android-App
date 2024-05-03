package com.example.bundoman

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils
import com.example.bundoman.room.TransactionDatabase
import com.example.bundoman.service.JWTService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DecimalFormat
import kotlin.properties.Delegates

class EditTransaksiActivity : NetworkSenseBaseActivity() {
    private var aId by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_transaksi)

        networkSnackbar = Snackbar.make(
            findViewById(R.id.main),
            R.string.no_internet,
            Snackbar.LENGTH_LONG
        )

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            NavUtils.navigateUpFromSameTask(this)
        }

        val titleEditText = findViewById<TextView>(R.id.title_edit_text)
        val nominalEditText = findViewById<TextView>(R.id.nominal_edit_text)
        val locationEditText = findViewById<TextView>(R.id.location_edit_text)

        // Get intent extras
        val intent = intent
        aId = intent.getIntExtra("iId", -1)
        val aTitle = intent.getStringExtra("iTitle")
        val aNominal = intent.getDoubleExtra("iNominal", 0.0)
        val aLocation = intent.getStringExtra("iLocation")

        // Set text to TextInputEditText fields
        titleEditText.text = aTitle
        val df = DecimalFormat("#.##")
        nominalEditText.text = df.format(aNominal)
        locationEditText.text = aLocation

        val deleteButton: TextView = findViewById(R.id.deleteButton)

        deleteButton.setOnClickListener {
            showDeleteConfirmationDialog()
        }

        val saveButton : Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            val nom = nominalEditText.text.toString().toDoubleOrNull()
            if (nom == null) {
                Toast.makeText(this, "Nominal harus berupa angka", Toast.LENGTH_SHORT).show()
            } else if (titleEditText.text.toString().isEmpty() ||
                locationEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "Tidak boleh ada data yang kosong", Toast.LENGTH_SHORT).show()
            }
            else {
                val transaction = TransactionDatabase.getDatabase(this).transactionDAO.getTransaction(aId)
                transaction.title = titleEditText.text.toString()
                transaction.value = nominalEditText.text.toString().toDouble()
                transaction.location = locationEditText.text.toString()

                Toast.makeText(applicationContext, "Menyimpan transaksi", Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        TransactionDatabase.getDatabase(applicationContext).transactionDAO.updateTransaction(
                            transaction
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
        if (!JWTService.is_jwt_running) {
            startService(Intent(this, JWTService::class.java))
        }
    }

    private fun showDeleteConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Hapus Transaksi")
            .setMessage("Apakah kamu yakin untuk menghapus transaksi ini?")
            .setPositiveButton("Ya") { _, _ ->
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        TransactionDatabase.getDatabase(applicationContext).transactionDAO.deleteTransactionWithId(aId)
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                applicationContext,
                                "Penghapusan transaksi berhasil",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                applicationContext,
                                "Penghapusan transaksi gagal : " + e.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
            .setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

}