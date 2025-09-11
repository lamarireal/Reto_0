package com.example.reto0

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class LogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        val listView: ListView = findViewById(R.id.listViewLog)
        val btnBack: Button = findViewById(R.id.btnBack)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            MonitorAlarmActivity.logChanges
        )
        listView.adapter = adapter

        btnBack.setOnClickListener {
            finish()
        }
    }
}

