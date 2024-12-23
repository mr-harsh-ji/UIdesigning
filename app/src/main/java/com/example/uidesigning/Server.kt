package com.example.uidesigning

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Server : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server)

        val nameTextView = findViewById<TextView>(R.id.textViewName)
        val ageTextView = findViewById<TextView>(R.id.textViewAge)

        val intent = intent
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")

        nameTextView.text = "Name: $name"
        ageTextView.text = "Age: $age"
    }
}