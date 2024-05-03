package com.example.bundoman

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils
import androidx.core.view.isEmpty
import com.example.bundoman.room.TransactionDatabase
import com.example.bundoman.room.TransactionEntity
import com.example.bundoman.service.JWTService
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DecimalFormat
import kotlin.random.Random

class AddTransaksiActivity : NetworkSenseBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaksi)

        val categorySpinner: Spinner = findViewById(R.id.category)
        ArrayAdapter.createFromResource(
            this,
            R.array.transaction_categories,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            categorySpinner.adapter = adapter
        }

        networkSnackbar = Snackbar.make(
            findViewById(R.id.main),
            R.string.no_internet,
            Snackbar.LENGTH_LONG
        )

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val titleInput : TextInputEditText = findViewById(R.id.title_add_text)
        val nominalInput : TextInputEditText = findViewById(R.id.nominal_add_text)
        val locationInput : TextInputEditText = findViewById(R.id.location_add_text)

        titleInput.setText(randomTitle)
        val df = DecimalFormat("#.##")
        nominalInput.setText(df.format(randomNominal))

        toolbar.setNavigationOnClickListener {
            NavUtils.navigateUpFromSameTask(this)
        }

        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            val nom = nominalInput.text.toString().toDoubleOrNull()
            if (nom == null) {
                Toast.makeText(this, "Nominal harus berupa angka", Toast.LENGTH_SHORT).show()
            } else if (titleInput.text.toString().isEmpty() || categorySpinner.isEmpty() ||
                locationInput.text.toString().isEmpty()) {
                Toast.makeText(this, "Tidak boleh ada data yang kosong", Toast.LENGTH_SHORT).show()
            } else {
                val transaction = TransactionEntity(
                    title = titleInput.text.toString(),
                    category = categorySpinner.selectedItem.toString(),
                    value = nominalInput.text.toString().toDouble(),
                    location = locationInput.text.toString(),
                    latitude = LocManager.currentLatitude,
                    langitude = LocManager.currentLongitude,
                )
                if (validateInputs(transaction.title, (transaction.value).toString(), transaction.location)) {
                    Toast.makeText(applicationContext, "Menyimpan transaksi", Toast.LENGTH_SHORT).show()
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            TransactionDatabase.getDatabase(applicationContext).transactionDAO.insertTransaction(
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
    }

    override fun onResume() {
        super.onResume()
        if (!JWTService.is_jwt_running) {
            startService(Intent(this, JWTService::class.java))
        }
        val locationInput : TextInputEditText = findViewById(R.id.location_add_text)
        // Isi lokasi
        LocManager.checkLocationPermissionAndGetLocation(this, locationInput)
    }

    private fun validateInputs(title: String, nominal: String, location: String): Boolean {
        // Title Validation
        if (title.length > 20) {
            Toast.makeText(this, "Nama transaksi tidak valid", Toast.LENGTH_SHORT).show()
            return false
        }

        // Nominal Validation 
        if (!nominal.matches(Regex("^\\d+(\\.\\d+)?$"))) {
            Toast.makeText(this, "Nominal harus angka positif", Toast.LENGTH_SHORT).show()
            return false
        }
        val nominalValue = nominal.toDouble()
        if (nominalValue <= 0 || nominalValue > 1_000_000_000) {
            Toast.makeText(this, "Nominal harus realistis", Toast.LENGTH_SHORT).show()
            return false
        }

        // Location Validation
        if (location.isEmpty() || location.length > 200 || !location.matches(Regex("^[a-zA-Z\\s]+$"))) {
            Toast.makeText(this, "Lokasi tidak valid", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    companion object {
        private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        private var randomTitle = ""
        private var randomNominal = 0.0
        val randomizeReceiver = RandomizeReceiver()

        private fun randomStringGenerator() : String {
            val stringLength = (1..20).random()
            return List(stringLength) { charPool.random() }.joinToString("")
        }

        fun randomizeTransaction() {
            randomTitle = randomStringGenerator()
            randomNominal = Random.nextDouble(1000000.0)
        }
    }
}