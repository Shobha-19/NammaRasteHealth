package com.example.nammarastehealth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Set initial camera to Bengaluru (12.9716° N, 77.5946° E)
        val bengaluru = LatLng(12.9716, 77.5946)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bengaluru, 12f))

        // Example markers to demonstrate color indicators
        addRoadStatusMarker(LatLng(12.9716, 77.5946), "MG Road", true)  // Good
        addRoadStatusMarker(LatLng(12.9300, 77.5800), "Jayanagar", false) // Bad
    }

    private fun addRoadStatusMarker(position: LatLng, title: String, isGood: Boolean) {
        val markerColor = if (isGood) {
            BitmapDescriptorFactory.HUE_GREEN // Matches "Green (Good)" in image
        } else {
            BitmapDescriptorFactory.HUE_RED   // Matches "Red (Bad)" in image
        }

        mMap.addMarker(
            MarkerOptions()
                .position(position)
                .title(title)
                .icon(BitmapDescriptorFactory.defaultMarker(markerColor))
        )
    }
}