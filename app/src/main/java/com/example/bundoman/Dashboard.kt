package com.example.bundoman

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bundoman.databinding.ActivityDashboardBinding
import com.example.bundoman.repository.TransactionRepository
import com.example.bundoman.room.TransactionDatabase
import com.example.bundoman.service.JWTService
import com.example.bundoman.ui.listTransaction.ListTransactionViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView
import com.google.android.material.snackbar.Snackbar

class Dashboard : NetworkSenseBaseActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private var headerText: String = ""
    private lateinit var viewModel: ListTransactionViewModel
    companion object {
        private const val HEADER_TEXT_KEY = "header_text"
    }

    fun getViewModel(): ListTransactionViewModel {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ListTransactionViewModel(TransactionRepository(TransactionDatabase.getDatabase(this)))
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        networkSnackbar = Snackbar.make(
            findViewById(R.id.main),
            R.string.no_internet,
            Snackbar.LENGTH_LONG
        )

        // Restore header text if it was saved
        if (savedInstanceState != null) {
            headerText = savedInstanceState.getString(HEADER_TEXT_KEY, "")
            setHeaderText(headerText)
        } else {
            // Set the initial fragment and header text
            replaceFragment(Transaksi())
            setHeaderText("Transaksi")
        }

        // Check if BottomNavigationView is available
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        if (bottomNavigationView != null) {
            // Portrait mode
            setupBottomNavigation(bottomNavigationView)
        } else {
            // Landscape mode
            val navigationRail = findViewById<NavigationRailView>(R.id.navigation_rail)
            setupNavigationRail(navigationRail)
        }

        // Set the selected item based on the currently displayed fragment
        when (headerText) {
            "Transaksi" -> bottomNavigationView?.selectedItemId = R.id.transaksi
            "Scan" -> bottomNavigationView?.selectedItemId = R.id.scan
            "Grafik" -> bottomNavigationView?.selectedItemId = R.id.grafik
            "Pengaturan" -> bottomNavigationView?.selectedItemId = R.id.pengaturan
        }
    }

    override fun onResume() {
        super.onResume()
        if (!JWTService.is_jwt_running) {
            startService(Intent(this, JWTService::class.java))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(HEADER_TEXT_KEY, headerText)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun setHeaderText(text: String) {
        headerText = text
        binding.headerTextView.text = text
    }

    private fun setupBottomNavigation(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.transaksi -> {
                    setHeaderText("Transaksi")
                    Transaksi()
                }
                R.id.scan -> {
                    setHeaderText("Scan")
                    Scan()
                }
                R.id.twibbon -> {
                    setHeaderText("Twibbon")
                    Twibbon()
                }
                R.id.grafik -> {
                    setHeaderText("Grafik")
                    Grafik()
                }
                R.id.pengaturan -> {
                    setHeaderText("Pengaturan")
                    Pengaturan()
                }
                else -> null
            }

            // Replace the fragment if not null
            fragment?.let { replaceFragment(it) }

            true
        }
    }

    private fun setupNavigationRail(navigationRail: NavigationRailView) {
        navigationRail.setOnItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.transaksi -> {
                    setHeaderText("Transaksi")
                    Transaksi()
                }
                R.id.scan -> {
                    setHeaderText("Scan")
                    Scan()
                }
                R.id.twibbon -> {
                    setHeaderText("Twibbon")
                    Twibbon()
                }
                R.id.grafik -> {
                    setHeaderText("Grafik")
                    Grafik()
                }
                R.id.pengaturan -> {
                    setHeaderText("Pengaturan")
                    Pengaturan()
                }
                else -> null
            }

            // Replace the fragment if not null
            fragment?.let { replaceFragment(it) }

            true
        }

        // Set the selected item based on the currently displayed fragment
        when (headerText) {
            "Transaksi" -> navigationRail.selectedItemId = R.id.transaksi
            "Scan" -> navigationRail.selectedItemId = R.id.scan
            "Twibbon" -> navigationRail.selectedItemId = R.id.twibbon
            "Grafik" -> navigationRail.selectedItemId = R.id.grafik
            "Pengaturan" -> navigationRail.selectedItemId = R.id.pengaturan
        }
    }
}
