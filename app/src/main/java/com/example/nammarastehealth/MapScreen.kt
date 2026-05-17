package com.example.nammarastehealth

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapScreen : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_map_screen)

        // Handles the edge-to-edge padding for system bars
        val mainView = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the map fragment
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Center on Bengaluru as seen in Screen 5 of IMG-20260504-WA0013.jpg
        val bengaluru = LatLng(12.9716, 77.5946)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bengaluru, 12f))

        // Example Markers: Green = Good, Red = Bad
        addRoadMarker(LatLng(12.9716, 77.5946), "MG Road", true)
        addRoadMarker(LatLng(12.9300, 77.5800), "Jayanagar", false)
        addRoadMarker(LatLng(12.9780, 77.6400), "Indiranagar", true)
    }

    private fun addRoadMarker(latLng: LatLng, title: String, isGood: Boolean) {
        val color =
            if (isGood) BitmapDescriptorFactory.HUE_GREEN else BitmapDescriptorFactory.HUE_RED

        // Using string resources for marker titles
        val statusText =
            if (isGood) getString(R.string.status_good) else getString(R.string.status_bad)

        mMap.addMarker(
            MarkerOptions()
                .position(latLng)
                .title("$title - $statusText")
                .icon(BitmapDescriptorFactory.defaultMarker(color))
        )
    }
}