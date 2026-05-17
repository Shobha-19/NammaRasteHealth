package com.example.nammarastehealth

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.card.MaterialCardView

class RoadDirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_road_directory)

        val etSearch = findViewById<EditText>(R.id.etSearchRoad)

        try {
            val cardMGRoad = findViewById<MaterialCardView>(R.id.cardMGRoad)
            val cardHosurRoad = findViewById<MaterialCardView>(R.id.cardHosurRoad)

            cardMGRoad?.setOnClickListener {
                Toast.makeText(this,
                    "MG Road - GOOD\nStatus: No Damage\nLocation: Bengaluru Central",
                    Toast.LENGTH_LONG).show()
            }
            cardHosurRoad?.setOnClickListener {
                Toast.makeText(this,
                    "Hosur Road - BAD\nStatus: 12 Potholes reported\nLocation: Bengaluru South",
                    Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Search Logic with all roads
        etSearch.addTextChangedListener {
            val query = it.toString().lowercase()
            if (query.length > 2) {
                when {
                    query.contains("mg") || query.contains("good") ->
                        Toast.makeText(this, "MG Road - GOOD ✅", Toast.LENGTH_SHORT).show()

                    query.contains("hosur") ->
                        Toast.makeText(this, "Hosur Road - BAD ❌", Toast.LENGTH_SHORT).show()

                    query.contains("chikka") || query.contains("bannavara") ->
                        Toast.makeText(this, "Chikkabannavara Road - GOOD ✅",
                            Toast.LENGTH_SHORT).show()

                    query.contains("hesar") || query.contains("ghatta") ->
                        Toast.makeText(this, "Hesaraghatta Road - BAD ❌",
                            Toast.LENGTH_SHORT).show()

                    query.contains("kr") || query.contains("puram") ->
                        Toast.makeText(this, "KR Puram Road - AVERAGE ⚠️",
                            Toast.LENGTH_SHORT).show()

                    query.contains("yesh") || query.contains("wantpur") ->
                        Toast.makeText(this, "Yeshwantpur Road - GOOD ✅",
                            Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}