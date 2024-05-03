package com.example.bundoman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

open class NetworkSenseBaseActivity : AppCompatActivity(), NetworkHandler.CustomNetworkCallback  {
    lateinit var networkHandler: NetworkHandler
    lateinit var networkSnackbar : Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkHandler = NetworkHandler(this, this)
    }

    override fun onResume() {
        super.onResume()
        networkHandler.register()
        if (!networkHandler.hasInternet()) {
            onNetNotAvailable()
        }
    }

    override fun onPause() {
        networkHandler.unregister()
        networkSnackbar.dismiss()
        super.onPause()
    }

    override fun onNetAvailable() {
        networkSnackbar.dismiss()
    }

    override fun onNetNotAvailable() {
        networkSnackbar.show()
    }
}