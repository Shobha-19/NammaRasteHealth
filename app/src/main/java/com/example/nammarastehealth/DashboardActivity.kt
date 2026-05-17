package com.example.nammarastehealth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val cardReport = findViewById<MaterialCardView>(R.id.cardReport)
        val cardMap = findViewById<MaterialCardView>(R.id.cardMap)
        val cardDirectory = findViewById<MaterialCardView>(R.id.cardDirectory)
        val cardContractor = findViewById<MaterialCardView>(R.id.cardContractor)

        cardDirectory.setOnClickListener {
            val intent = Intent(this, RoadDirectoryActivity::class.java)
            startActivity(intent)
        }

        cardReport.setOnClickListener {
            val intent = Intent(this, ReportDamageActivity::class.java)
            startActivity(intent)
        }

        cardMap.setOnClickListener {
            val intent = Intent(this, MapScreen::class.java)
            startActivity(intent)
        }

        cardContractor.setOnClickListener {
            val intent = Intent(this, ContractorActivity::class.java)
            startActivity(intent)
        }
    }
}