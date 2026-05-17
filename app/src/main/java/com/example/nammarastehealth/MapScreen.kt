package com.example.nammarastehealth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapScreen : AppCompatActivity() {

    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance().userAgentValue = packageName
        setContentView(R.layout.activity_map_screen)

        map = findViewById(R.id.map_fragment)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)

        val mapController = map.controller
        mapController.setZoom(12.0)
        val bengaluru = GeoPoint(12.9716, 77.5946)
        mapController.setCenter(bengaluru)

        // Green markers - Good roads
        addMarker(GeoPoint(12.9716, 77.5946), "MG Road - GOOD", true)
        addMarker(GeoPoint(12.9780, 77.6400), "Indiranagar - GOOD", true)
        // Red markers - Bad roads
        addMarker(GeoPoint(12.9300, 77.5800), "Jayanagar - BAD", false)
        addMarker(GeoPoint(12.9500, 77.6200), "Hosur Road - BAD", false)
    }

    private fun addMarker(point: GeoPoint, title: String, isGood: Boolean) {
        val marker = Marker(map)
        marker.position = point
        marker.title = title
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.icon = if (isGood)
            resources.getDrawable(R.drawable.ic_marker_green, null)
        else
            resources.getDrawable(R.drawable.ic_marker_red, null)
        map.overlays.add(marker)
    }

    override fun onResume() { super.onResume(); map.onResume() }
    override fun onPause() { super.onPause(); map.onPause() }
}