package com.example.bundoman

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.bundoman.room.TransactionDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pengaturan.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pengaturan : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        LocalBroadcastManager.getInstance(requireContext()).
                                registerReceiver(AddTransaksiActivity.randomizeReceiver,
                                    IntentFilter("RANDOMIZE_TRANSACT")
                                )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pengaturan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set click listener to send email
        val sendEmailButton = view.findViewById<Button>(R.id.kirimButton)
        sendEmailButton.setOnClickListener {
            val sharedPrefs : SharedPreferences =
                requireContext().getSharedPreferences("BondoMan", Context.MODE_PRIVATE)
            Email.sendMail(requireContext(), sharedPrefs.getString("CurrEmail", "").toString(), "Daftar Transaksi",
                            ExcelManager.getTransactionFile(requireContext(),
                                TransactionDatabase.getDatabase(requireContext()).transactionDAO.getAllTransactionAsList(),
                                lifecycleScope))
        }
        val randomizeTransactButton = view.findViewById<Button>(R.id.randomizeButton)
        randomizeTransactButton.setOnClickListener {
            val randIt = Intent("RANDOMIZE_TRANSACT")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(randIt)
            Toast.makeText(requireContext(), "Mengacak field tambah transaksi", Toast.LENGTH_SHORT).show()
        }
        val logOutButton = view.findViewById<Button>(R.id.logoutButton)
        logOutButton.setOnClickListener {
            Login.logout(requireContext())
        }

        val saveTransactionsButton = view.findViewById<Button>(R.id.simpanButton)
        saveTransactionsButton.setOnClickListener {
            // AlertDialog to choose format
            val formats = arrayOf(".xlsx", ".xls")
            AlertDialog.Builder(requireContext()).apply {
                setTitle("Pilih Format Penyimpanan")
                setItems(formats) {dialog, which -> 
                    val format = formats[which]
                    val transactionList = TransactionDatabase.getDatabase(requireContext()).transactionDAO.getAllTransactionAsList()
                    ExcelManager.saveTransactions(requireContext(), transactionList, lifecycleScope, format)
                    dialog.dismiss()
                }
                show()
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Pengaturan.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pengaturan().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}