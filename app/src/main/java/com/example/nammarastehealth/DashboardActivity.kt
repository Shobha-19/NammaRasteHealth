package com.example.nammarastehealth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Find the cards by their IDs
        val cardReport = findViewById<MaterialCardView>(R.id.cardReport)
        val cardMap = findViewById<MaterialCardView>(R.id.cardMap)
        val cardDirectory = findViewById<com.google.android.material.card.MaterialCardView>(R.id.cardDirectory)
        cardDirectory.setOnClickListener {
            val intent = Intent(this, RoadDirectoryActivity::class.java)
            startActivity(intent)
        }

        cardReport.setOnClickListener {
            // This will stay red until you do Step 2 below!
            val intent = Intent(this, ReportDamageActivity::class.java)
            startActivity(intent)
        }

        cardMap.setOnClickListener {
            // This will stay red until you do Step 3 below!
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}