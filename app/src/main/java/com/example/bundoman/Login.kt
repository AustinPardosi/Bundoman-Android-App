package com.example.bundoman

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bundoman.models.User
import com.example.bundoman.repository.TokenRepo
import com.example.bundoman.repository.UserRepo
import com.example.bundoman.service.JWTService
import com.example.bundoman.service.TokenApi
import com.example.bundoman.service.UserApi
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.util.Patterns

class Login : NetworkSenseBaseActivity(){
    companion object {
        private var loggingIn = false
        private var calledByLoginPage = false
        var currEmail = ""
        private var currPassword = ""

        fun relogin(context : Context) {
            val sharedPrefs : SharedPreferences =
                context.getSharedPreferences("BondoMan", Context.MODE_PRIVATE)
            if (currEmail == "") {
                currEmail = sharedPrefs.getString("CurrEmail", "").toString()
            }
            login(context, currEmail, currPassword)
        }

        fun login(context : Context, email : String, password : String) {
            if (loggingIn) {
                Toast.makeText(context, "Sedang log in", Toast.LENGTH_SHORT).show()
            }
            loggingIn = true
            val userRepo = UserRepo(NetworkHandler.getRetrofitClient().create(UserApi::class.java))
            // Initiate shared preferences to store jwt token
            val editor : SharedPreferences.Editor
            val sharedPrefs : SharedPreferences =
                context.getSharedPreferences("BondoMan", Context.MODE_PRIVATE)
            editor = sharedPrefs.edit()
            // Call log in function in coroutine
            CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    try {
                        val userData = User(email, password)
                        val response = userRepo.getLoginToken(userData)
                        if (response.isSuccessful) {
                            val token = response.body()?.token.toString()
                            // Get token expiry time
                            val tokenRepo = TokenRepo(
                                NetworkHandler.getRetrofitClient().create(TokenApi::class.java)
                            )
                            val responseTokenExp = tokenRepo.checkTokenExp(token)
                            if (responseTokenExp.isSuccessful) {
                                // Save token and exp time in shared preferences
                                currEmail = email
                                currPassword = password
                                editor.putString("Token", token)
                                editor.putLong("TokenExp", responseTokenExp.body()!!.exp)
                                editor.putString("CurrEmail", email)
                                editor.apply()
                                // Start token expiry service
                                context.startService(Intent(context, JWTService::class.java))
                                if (calledByLoginPage) {
                                    context.startActivity(
                                        Intent(
                                            context,
                                            Dashboard::class.java
                                        )
                                    )
                                    if (context is Activity) {
                                        context.finish()
                                    }
                                }
                            } else {
                                Toast.makeText(
                                    context,
                                    "Gagal menyimpan token",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            if (calledByLoginPage) {
                                Toast.makeText(
                                    context,
                                    "Email atau password salah",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    context.applicationContext,
                                    "Token kedaluwarsa, silakan login ulang",
                                    Toast.LENGTH_SHORT
                                ).show()
                                logout(context)
                            }
                        }
                    } catch (e : Exception) {
                        // Log out if no internet
                        if (calledByLoginPage) {
                            val intent = Intent(context, NoInternet::class.java)
                            context.startActivity(intent)
                        } else {
                            logout(context)
                        }
                    }
                    loggingIn = false
                    calledByLoginPage = false
                }
            }
        }

        fun logout(context: Context) {
            // Initiate shared preferences to delete jwt token
            val editor : SharedPreferences.Editor
            val sharedPrefs : SharedPreferences =
                context.getSharedPreferences("BondoMan", Context.MODE_PRIVATE)
            editor = sharedPrefs.edit()
            editor.remove("Token")
            editor.remove("TokenExp")
            editor.remove("CurrEmail")
            editor.apply()
            context.stopService(Intent(context, JWTService::class.java))
            context.startActivity(Intent(context, Login::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
            if (context is Activity) {
                context.finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        networkSnackbar = Snackbar.make(
            findViewById(R.id.main_scrollview),
            R.string.no_internet,
            Snackbar.LENGTH_LONG
        )

        val emailEditText = findViewById<EditText>(R.id.email_edit_text)
        val passwordEditText = findViewById<EditText>(R.id.password_edit_text)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if email and password are valid
            if (validateEmail(email) && validatePassword(password)) {
                Toast.makeText(this, "Mulai log in", Toast.LENGTH_SHORT).show()
                calledByLoginPage = true
                login(this, email, password)
            } else {
                Toast.makeText(this, "Format email atau password tidak valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: String): Boolean {
        val passwordRegex = "^password_\\d{8}$"
        return password.matches(passwordRegex.toRegex())
    }
}
