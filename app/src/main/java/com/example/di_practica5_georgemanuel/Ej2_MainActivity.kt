package com.example.di_practica5_georgemanuel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ej2_MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdaptSolar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej2_main)

        recyclerView = findViewById(R.id.recyclerViewSolar)
        recyclerView.setHasFixedSize(true)

        // Crear datos de ejemplo (asegúrate de tener los drawables)
        val solarList = mutableListOf(
            SolarItem("Sol 1", R.drawable.corona_solar),
            SolarItem("Sol 2", R.drawable.erupcionsolar),
            SolarItem("Sol 3", R.drawable.espiculas),
            SolarItem("Sol 4", R.drawable.filamentos),
            SolarItem("Sol 5", R.drawable.magnetosfera),
            SolarItem("Sol 6", R.drawable.manchasolar)
        )

        adapter = AdaptSolar(solarList)
        recyclerView.adapter = adapter

        // Grid de 2 columnas (ajusta según diseño)
        val spanCount = 2
        recyclerView.layoutManager = GridLayoutManager(this, spanCount)
    }
}
