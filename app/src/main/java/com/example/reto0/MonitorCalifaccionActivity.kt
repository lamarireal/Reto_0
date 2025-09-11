package com.example.reto0

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

@SuppressLint("UseSwitchCompatOrMaterialCode")
class MonitorCalifaccionActivity : AppCompatActivity() {

    private lateinit var btnChange: Button
    private lateinit var btnLog: Button
    private lateinit var btnPlano1: Button
    private lateinit var textEstado: TextView
    private lateinit var image: ImageView
    private lateinit var swRouter: Switch

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
        swRouter = findViewById(R.id.switchRouter)

        btnChange.setOnClickListener { changeModeAlarm() }

        btnLog.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }

        btnPlano1.setOnClickListener {
            finish()
        }

        swRouter.setOnCheckedChangeListener { _, isChecked ->
            val estadoText = if (isChecked) "Activado" else "Desactivado"

            Toast.makeText(this, "Router $estadoText", Toast.LENGTH_SHORT).show()

            LogManager.addLog("Estado del router cambiado a: $estadoText")
        }

        updateUI()
    }

    private fun changeModeAlarm() {
        estadoManejo = !estadoManejo

        val estadoText = if (estadoManejo) "Activado" else "Desactivado"
        LogManager.addLog("Estado de califaccion cambiado a: $estadoText")

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
