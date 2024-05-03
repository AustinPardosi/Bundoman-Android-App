package com.example.bundoman

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.bundoman.room.TransactionEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Locale

object ExcelManager {
    private const val EXCEL_DIRECTORY = "/excel_files"

    fun saveTransactions(context: Context, transactions: List<TransactionEntity>, scope: CoroutineScope, format: String) {
        scope.launch(Dispatchers.IO) {
            try {
                val workbook = if (format == ".xlsx") {
                    XSSFWorkbook()
                } else {
                    HSSFWorkbook()
                }

                val sheet = workbook.createSheet("Transaksi")

                val headerRow = sheet.createRow(0)
                headerRow.createCell(0).setCellValue("ID")
                headerRow.createCell(1).setCellValue("Tanggal")
                headerRow.createCell(2).setCellValue("Nama_Transaksi")
                headerRow.createCell(3).setCellValue("Kategori")
                headerRow.createCell(4).setCellValue("Nominal")
                headerRow.createCell(5).setCellValue("Lokasi")
                headerRow.createCell(6).setCellValue("Latitude")
                headerRow.createCell(7).setCellValue("Longitude")

                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale("id", "ID"))

                transactions.forEachIndexed { index, data ->
                    val row = sheet.createRow(index + 1)
                    row.createCell(0, CellType.NUMERIC).setCellValue(data.id.toDouble())
                    row.createCell(1, CellType.STRING).setCellValue(dateFormat.format(data.date))
                    row.createCell(2, CellType.STRING).setCellValue(data.title)
                    row.createCell(3, CellType.STRING).setCellValue(data.category)
                    row.createCell(4, CellType.NUMERIC).setCellValue(data.value)
                    row.createCell(5, CellType.STRING).setCellValue(data.location)
                    row.createCell(6, CellType.NUMERIC).setCellValue(data.latitude)
                    row.createCell(7, CellType.NUMERIC).setCellValue(data.langitude)
                }

                val fileName = if (format == ".xlsx") "DaftarTransaksi.xlsx" else "DaftarTransaksi.xls"


                val file = createExcelFile(fileName);
                FileOutputStream(file).use { outputStream ->
                    workbook.write(outputStream)
                }
                workbook.close()
                withContext(Dispatchers.Main) {
                    // Display a toast message indicating the file was saved successfully
                    Toast.makeText(context, "File berhasil disimpan di ${file.absolutePath}", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("error", e.toString())
                    Toast.makeText(context, "Error menyimpan file: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun createExcelFile(fileName: String): File {
        if (Environment.getExternalStorageState() != Environment.MEDIA_MOUNTED) {
            throw IOException("The external storage is not mounted or not writable")
        }

        val downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val file = File(downloadsDirectory, fileName)
        if (!file.exists()) {
            val created = file.createNewFile()
            if (!created) {
                throw IOException("Failed to create new file: $fileName")
            }
        }
        return file
    }

    fun getTransactionFile(context: Context, transactions: List<TransactionEntity>, scope: CoroutineScope) : Uri {
        val tempFile = File.createTempFile("Daftar Transaksi", ".xlsx")
        scope.launch(Dispatchers.IO) {
            try {
                val workbook = XSSFWorkbook()
                val sheet = workbook.createSheet("Transaksi")

                val headerRow = sheet.createRow(0)
                headerRow.createCell(0).setCellValue("ID")
                headerRow.createCell(1).setCellValue("Tanggal")
                headerRow.createCell(2).setCellValue("Nama_Transaksi")
                headerRow.createCell(3).setCellValue("Kategori")
                headerRow.createCell(4).setCellValue("Nominal")
                headerRow.createCell(5).setCellValue("Lokasi")
                headerRow.createCell(6).setCellValue("Latitude")
                headerRow.createCell(7).setCellValue("Longitude")

                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale("id", "ID"))

                transactions.forEachIndexed { index, data ->
                    val row = sheet.createRow(index + 1)
                    row.createCell(0, CellType.NUMERIC).setCellValue(data.id.toDouble())
                    row.createCell(1, CellType.STRING).setCellValue(dateFormat.format(data.date))
                    row.createCell(2, CellType.STRING).setCellValue(data.title)
                    row.createCell(3, CellType.STRING).setCellValue(data.category)
                    row.createCell(4, CellType.NUMERIC).setCellValue(data.value)
                    row.createCell(5, CellType.STRING).setCellValue(data.location)
                    row.createCell(6, CellType.NUMERIC).setCellValue(data.latitude)
                    row.createCell(7, CellType.NUMERIC).setCellValue(data.langitude)
                }

                FileOutputStream(tempFile).use { outputStream ->
                    workbook.write(outputStream)
                }
                workbook.close()
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("error", e.toString())
                    Toast.makeText(context, "Error membuat file: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
        tempFile.deleteOnExit()
        return FileProvider.getUriForFile(context, context.getString(R.string.authorities),
                                            tempFile)
    }
}