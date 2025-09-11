package com.example.reto0

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText

    private lateinit var btnIniciar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        name = findViewById(R.id.etNombreUsuario)
        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPassword)

        btnIniciar = findViewById(R.id.btnLogin)

        btnIniciar.setOnClickListener { login() }
    }

    private fun login() {
        val nameUser = name.text.toString()
        val emailUser = email.text.toString()
        val passUser = password.text.toString()

        if (nameUser != "" && emailUser != "" && passUser != "") {
            if (emailUser == "admin" && passUser == "admin") {
                val intent = Intent(this, MonitorAlarmActivity::class.java).apply {
                    putExtra("Nombre", nameUser)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "email o contraseña no son correctos", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}