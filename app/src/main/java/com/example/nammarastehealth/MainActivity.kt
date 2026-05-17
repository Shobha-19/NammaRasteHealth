package com.example.nammarastehealth

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    // 1. Declare Firebase variables
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. Correct Initialization
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Delay for 2 seconds
        Handler(Looper.getMainLooper()).postDelayed({

            // 3. Check if user is logged in
            val currentUser = auth.currentUser
            if (currentUser != null) {
                // Already logged in -> Dashboard
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                // Not logged in -> Login
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 2000)
    }
}