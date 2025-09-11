package com.example.reto0

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MonitorAlarmActivity : AppCompatActivity() {

    private lateinit var btnChange: Button
    private lateinit var btnLog: Button
    private lateinit var btnPlano2: Button
    private lateinit var textEstado: TextView
    private lateinit var image: ImageView

    private var estadoAlarm: Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        btnChange = findViewById(R.id.btnCambiar)
        btnLog = findViewById(R.id.btnLog)
        btnPlano2 = findViewById(R.id.btnPlano1)

        textEstado = findViewById(R.id.tvEstado)
        image = findViewById(R.id.imageView)

        btnChange.setOnClickListener { changeModeAlarm() }

        btnLog.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }

        btnPlano2.setOnClickListener {
            val intent = Intent(this, MonitorCalifaccionActivity::class.java)
            startActivity(intent)
        }

        updateUI()
    }

    private fun changeModeAlarm() {
        estadoAlarm = !estadoAlarm

        val estadoText = if (estadoAlarm) "Activado" else "Desactivado"
        LogManager.addLog("Estado de las alarmas cambiado a: $estadoText")

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