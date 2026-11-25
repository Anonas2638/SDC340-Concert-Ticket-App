package com.example.paconcertticketapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

// Anosha Naseri
// PA 3.4 - Concert Ticket Mobile App
// November 25, 2026

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            setIcon(R.drawable.ic_concert_ticket)
            setDisplayUseLogoEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val event = findViewById<Spinner>(R.id.selEvent)
        val tickets = findViewById<EditText>(R.id.numTickets)
        val calculate = findViewById<Button>(R.id.btnCalculate)
        val total = findViewById<TextView>(R.id.txtTotal)

        calculate.setOnClickListener {

            val quantity = tickets.text.toString().toIntOrNull()

            if (quantity == null || quantity <= 0) {
                tickets.error = "Enter a valid number of tickets"

                Toast.makeText(
                    this,
                    "Please enter at least one ticket",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val price = when (event.selectedItemPosition) {
                0 -> 49.99
                1 -> 45.99
                2 -> 42.99
                else -> 0.0
            }

            val totalCost = quantity * price

            val formattedTotal = String.format(
                Locale.US, "$%.2f", totalCost
            )

            total.text = "Total Cost: $formattedTotal"
        }
    }
}
