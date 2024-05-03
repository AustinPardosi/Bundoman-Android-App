package com.example.bundoman

import android.content.Context
import android.content.Intent
import android.net.Uri

object Email {
    fun sendMail(context : Context, address : String, subject : String, attachment : Uri) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_EMAIL, Array(1){address})
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, "Berikut daftar transaksi anda")
            putExtra(Intent.EXTRA_STREAM, attachment)
            setType("message/rfc822")
        }
        context.startActivity(intent)
    }
}