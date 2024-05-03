package com.example.bundoman.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.HandlerThread
import android.os.IBinder
import android.os.Process
import com.example.bundoman.Login
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

class JWTService : Service() {
    companion object {
        var is_jwt_running = false
    }

    override fun onCreate() {
        // Start up the thread running the service.
        is_jwt_running = true
        HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND).apply {
            start()
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val sharedPrefs : SharedPreferences =
            applicationContext.getSharedPreferences("BondoMan", Context.MODE_PRIVATE)
        val expiredTime = sharedPrefs.getLong("TokenExp", 0)
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                if (Date().time/1000 > expiredTime) {
                    withContext(Dispatchers.Main) {
                        Login.relogin(applicationContext)
                        stopSelf()
                    }
                    break
                }
                delay(30000)
            }
        }

        // If we get killed, after returning from here, restart
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        stopSelf()
    }

    override fun onDestroy() {
        is_jwt_running = false
        super.onDestroy()
    }
}