package com.example.bundoman

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bundoman.service.JWTService
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val SPLASH_SCREEN = 3000L

    //Variables
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private lateinit var image: ImageView
    private lateinit var title: TextView
    private lateinit var tagline: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        // Hooks
        image = findViewById(R.id.imageView)
        title = findViewById(R.id.textView1)
        tagline = findViewById(R.id.textView4)

        image.animation = topAnim
        title.animation = bottomAnim
        tagline.animation = bottomAnim
    }

    override fun onResume() {
        super.onResume()
        // Check if jwt token is still valid
        val sharedPreferences = getSharedPreferences("BondoMan", Context.MODE_PRIVATE)
        val storedToken = sharedPreferences.getString("Token", "").toString()
        val netHandler = NetworkHandler(this, null)
        if (storedToken.compareTo("") != 0 && netHandler.hasInternet()) {
            // If token already expired while exiting app, logout
            if (Date().time/1000 > sharedPreferences.getLong("TokenExp", 0)) {
                Handler(Looper.getMainLooper()).postDelayed({
                    Login.logout(this)
                    finish()
                }, SPLASH_SCREEN)
            } else {
                Login.currEmail = sharedPreferences.getString("CurrEmail", "").toString()
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(applicationContext, Dashboard::class.java)
                    startActivity(intent)
                    finish()
                }, SPLASH_SCREEN)
            }
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                Login.logout(this)
                finish()
            }, SPLASH_SCREEN)
        }
    }
}