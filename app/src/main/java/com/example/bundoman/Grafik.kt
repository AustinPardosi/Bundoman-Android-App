package com.example.bundoman

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bundoman.room.TransactionDatabase
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class Grafik : Fragment() {

    private lateinit var pieChart: PieChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_grafik, container, false)
        pieChart = view.findViewById(R.id.pie_chart)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transactionList = TransactionDatabase.getDatabase(requireContext()).transactionDAO.getAllTransactionAsList()

        val pemasukanTransactions = transactionList.filter { it.category == "Pemasukan" }
        val pengeluaranTransactions = transactionList.filter { it.category == "Pengeluaran" }

        val totalPemasukan = pemasukanTransactions.sumOf { it.value }
        val totalPengeluaran = pengeluaranTransactions.sumOf { it.value }

        val list: ArrayList<PieEntry> = ArrayList()

        // Add total values to the pie chart
        list.add(PieEntry(totalPemasukan.toFloat(), "Pemasukan"))
        list.add(PieEntry(totalPengeluaran.toFloat(), "Pengeluaran"))

        val pieDataSet = PieDataSet(list, "List")
        pieDataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        pieDataSet.valueTextSize = 15f
        pieDataSet.valueTextColor = Color.BLACK

        val pieData = PieData(pieDataSet)
        pieChart.data = pieData
        pieChart.description.text = "Grafik Keuangan"
        pieChart.animateY(1000)
    }
}
