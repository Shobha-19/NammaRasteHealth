package com.example.nammarastehealth

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReportDamageActivity : AppCompatActivity() {

    private lateinit var ivRoadPhoto: ImageView
    private val CAMERA_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_damage)

        ivRoadPhoto = findViewById(R.id.ivRoadPhoto)
        val btnCapture = findViewById<Button>(R.id.btnCapture)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitReport)
        val tvLocation = findViewById<TextView>(R.id.tvLocation)

        // 📸 Open Camera
        btnCapture.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
        }

        // ✅ Submit Logic
        btnSubmit.setOnClickListener {
            // For now, we simulate a successful save
            Toast.makeText(this, "Report Submitted Successfully!", Toast.LENGTH_LONG).show()
            finish() // Go back to dashboard
        }

        // Simulating auto-location for now to ensure no crashes
        tvLocation.text = "📍 Location: 12.9716° N, 77.5946° E (Auto-detected)"
    }

    // This handles the result after the user takes a photo
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val photo = data?.extras?.get("data") as Bitmap
            ivRoadPhoto.setImageBitmap(photo)
        }
    }
}