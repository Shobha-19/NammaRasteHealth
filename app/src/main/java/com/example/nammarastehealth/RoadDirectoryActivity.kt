package com.example.nammarastehealth

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class RoadDirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_road_directory)

        val etSearch = findViewById<EditText>(R.id.etSearchRoad)

        // Mock Search Logic: To impress the teacher
        etSearch.addTextChangedListener {
            val query = it.toString()
            if (query.isNotEmpty()) {
                // In a real app, this would filter a list
                // For now, we show it's reacting
            }
        }
    }
}