package com.example.bundoman

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.Locale

object LocManager {
    private const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1
    var currentLatitude = 0.0
    var currentLongitude = 0.0

    fun checkLocationPermissionAndGetLocation(activity:Activity, locText : TextInputEditText) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
            )
        }
        getLastKnownLocation(activity, locText)
    }

    private fun getLastKnownLocation(context: Context, locText : TextInputEditText) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                currentLatitude = it.latitude
                currentLongitude = it.longitude
                CoroutineScope(Dispatchers.IO).launch {
                    val city = getCityFromLatLang(context, it.latitude, it.longitude)
                    withContext(Dispatchers.Main) {
                        locText.setText(city)
                    }
                }
            } ?: Toast.makeText(context, "Lokasi tidak terdeteksi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getCityFromLatLang(context: Context, latitude: Double, longitude: Double): String {
        val geocoder = Geocoder(context, Locale.getDefault())
        return try {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            if (addresses?.isNotEmpty() == true) {
                addresses[0].subAdminArea ?: "Unknown location"
            } else {
                "Location not found"
            }
        } catch (e: IOException) {
            e.printStackTrace()
            "Unable to get the location"
        }
    }
}