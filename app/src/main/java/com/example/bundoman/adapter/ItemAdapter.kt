package com.example.bundoman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bundoman.R

class ItemAdapter (private val nameList : ArrayList<String>, private val qtyList : ArrayList<Int>,
                    private val priceList : Array<Double>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView
        val itemQty : TextView
        val itemPrice: TextView

        init {
            // Define click listener for the ViewHolder's View
            itemName = view.findViewById(R.id.itemName)
            itemQty = view.findViewById(R.id.itemQty)
            itemPrice = view.findViewById(R.id.itemPrice)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.itemName.text = "Nama : " + nameList[position]
        viewHolder.itemQty.text = "Jumlah : " + qtyList[position].toString()
        viewHolder.itemPrice.text = "Harga satuan : " + priceList[position].toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = nameList.size
}