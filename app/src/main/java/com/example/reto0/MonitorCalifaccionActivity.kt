package com.example.reto0

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.reto0.MonitorAlarmActivity.Companion.logChanges

class MonitorCalifaccionActivity : AppCompatActivity() {

    private lateinit var btnChange: Button
    private lateinit var btnLog: Button
    private lateinit var btnPlano1: Button

    private lateinit var textEstado: TextView

    private lateinit var image: ImageView


    private var estadoManejo: Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_califaccion)

        btnChange = findViewById(R.id.btnChange)
        btnLog = findViewById(R.id.btnLog)
        btnPlano1 = findViewById(R.id.btnPlano1)

        textEstado = findViewById(R.id.tvEstado)

        image = findViewById(R.id.imageView)

        btnChange.setOnClickListener { changeModeAlarm() }

        btnLog.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }

        btnPlano1.setOnClickListener {  }

        updateUI()
    }

    private fun changeModeAlarm() {
        estadoManejo = !estadoManejo

        val estadoText = if (estadoManejo) "Activado" else "Desactivado"
        logChanges.add("Estado de califaccion cambiado a: $estadoText")

        updateUI()
    }


    private fun updateUI() {
        if (!estadoManejo) {
            image.setImageResource(R.drawable.plano_p1_sensor_apagado)
            textEstado.text = "Desactivado"
        } else {
            image.setImageResource(R.drawable.plano_p1_sensor_encendido)
            textEstado.text = "Activado"
        }
    }
}