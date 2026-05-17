package com.example.nammarastehealth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContractorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contractor)

        // Call buttons
        val btnCall1 = findViewById<LinearLayout>(R.id.btnCall1)
        val btnCall2 = findViewById<LinearLayout>(R.id.btnCall2)
        val btnCall3 = findViewById<LinearLayout>(R.id.btnCall3)

        btnCall1.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210")))
        }
        btnCall2.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:9845012345")))
        }
        btnCall3.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:9731234567")))
        }
    }
}