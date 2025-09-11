package com.example.reto0

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object LogManager {

    val logChanges = mutableListOf<String>()

    fun addLog(message: String) {
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val currentTime = sdf.format(Date())
        logChanges.add("[$currentTime] $message")
    }
}
