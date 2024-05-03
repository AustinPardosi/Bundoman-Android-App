package com.example.bundoman

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class RandomizeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        AddTransaksiActivity.randomizeTransaction()
    }
}