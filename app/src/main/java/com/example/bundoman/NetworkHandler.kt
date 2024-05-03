package com.example.bundoman

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkHandler(private val context: Context, private val customNetworkCallback: CustomNetworkCallback?) : ConnectivityManager.NetworkCallback() {
    val connectivityManager = context.getSystemService(ConnectivityManager::class.java)
    val networkRequest = NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED).build()

    companion object {
        private val baseUrl = "https://pbd-backend-2024.vercel.app"
        private val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseUrl)
            .build()

        var hasInternetAccess : Boolean = true

        fun getRetrofitClient(): Retrofit {
            return retrofit;
        }
    }

    fun register() {
        connectivityManager.registerNetworkCallback(networkRequest, this)
    }

    fun unregister() {
        connectivityManager.unregisterNetworkCallback(this)
    }

    fun hasInternet() : Boolean {
        val activeNet = connectivityManager.activeNetwork
        hasInternetAccess = if (activeNet != null) {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)!!.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            false
        }
        return hasInternetAccess
    }

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        customNetworkCallback?.onNetAvailable()
        hasInternetAccess = true
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        customNetworkCallback?.onNetNotAvailable()
        hasInternetAccess = false
    }

    override fun onUnavailable() {
        super.onUnavailable()
        customNetworkCallback?.onNetNotAvailable()
        hasInternetAccess = false
    }

    interface CustomNetworkCallback {
        fun onNetAvailable()
        fun onNetNotAvailable()
    }
}