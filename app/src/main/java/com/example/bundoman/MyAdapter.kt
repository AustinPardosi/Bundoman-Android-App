package com.example.bundoman

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bundoman.room.TransactionEntity
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MyAdapter(val transactions: List<TransactionEntity>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateText: TextView = itemView.findViewById(R.id.dateText)
        val titleText: TextView = itemView.findViewById(R.id.titleText)
        val nominalText: TextView = itemView.findViewById(R.id.nominalText)
        val categoryText: TextView = itemView.findViewById(R.id.categoryText)
        val locationText: TextView = itemView.findViewById(R.id.locationText)

        fun bindItems(transaction: TransactionEntity) {
            val formattedDate = formatDate(Date(transaction.date))
            dateText.text = formattedDate
            titleText.text = transaction.title

            val localeID = Locale("in", "ID") // Locale for Indonesia
            val formatter = NumberFormat.getNumberInstance(localeID)
            val formattedNominal = formatter.format(transaction.value)
            nominalText.text = "Rp $formattedNominal"
            
            categoryText.text = transaction.category
            locationText.text = transaction.location
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_transaksi, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.bindItems(transaction)

        holder.locationText.text = transaction.location
        holder.locationText.setOnClickListener {
            openLocationInMaps(context, transaction.latitude, transaction.langitude)
        }

        holder.itemView.setOnClickListener {
            val transaction = transactions[position]
            val intent = Intent(context, EditTransaksiActivity::class.java)
            intent.putExtra("iId", transaction.id)
            intent.putExtra("iTitle", transaction.title)
            intent.putExtra("iNominal", transaction.value)
            intent.putExtra("iCategory", transaction.category)
            intent.putExtra("iLocation", transaction.location)
            context.startActivity(intent)
        }
    }

    private fun openLocationInMaps(context: Context, latitude: Double, longitude: Double) {
        val gmmIntentUri = Uri.parse("geo:0,0?q=" + latitude.toBigDecimal().toPlainString() + "," + longitude.toBigDecimal().toPlainString())
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        context.startActivity(mapIntent)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    companion object {
        fun formatDate(date: Date): String {
            val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            return sdf.format(date)
        }
    }
}
