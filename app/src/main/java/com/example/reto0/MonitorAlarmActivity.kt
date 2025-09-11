package com.example.reto0

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MonitorAlarmActivity : AppCompatActivity() {

    private lateinit var btnChange: Button
    private lateinit var textEstado: TextView
    private lateinit var image: ImageView

    private var estadoAlarm: Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        btnChange = findViewById(R.id.btnCambiar)
        textEstado = findViewById(R.id.tvEstado)
        image = findViewById(R.id.imageView)

        btnChange.setOnClickListener { changeModeAlarm() }

        updateUI()
    }

    private fun changeModeAlarm() {
        estadoAlarm = !estadoAlarm
        updateUI()
    }

    private fun updateUI() {
        if (!estadoAlarm) {
            image.setImageResource(R.drawable.plano_p1_sensor_apagado)
            textEstado.text = "Desactivado"
        } else {
            image.setImageResource(R.drawable.plano_p1_sensor_encendido)
            textEstado.text = "Activado"
        }
    }
}