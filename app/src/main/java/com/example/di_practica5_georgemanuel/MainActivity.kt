package com.example.di_practica5_georgemanuel;

import android.os.Bundle
import android.view.View
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.di_practica5_georgemanuel.R
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    //lista de recursos de ejemplo
    private val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Travels"

        val imageSwitcher = findViewById<ImageSwitcher>(R.id.imageSwitcher)
        //configurar ViewFactory del ImageSwitcher
        imageSwitcher.setFactory(object : ViewSwitcher.ViewFactory {
            override fun makeView(): View {
                val iv = ImageView(applicationContext)
                iv.scaleType = ImageView.ScaleType.FIT_CENTER
                iv.adjustViewBounds = true
                return iv
            }
        })
        //poner una imagen inicial si quieres
        imageSwitcher.setImageResource(images.first())

        //recyclerView horizontal
        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = ImageAdapter(images)
        rv.adapter = adapter
    }
}
