package com.example.di_practica5_georgemanuel;

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ImageSwitcher
import androidx.recyclerview.widget.RecyclerView
import com.example.di_practica5_georgemanuel.R

class ImageAdapter(private val images: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumb: ImageView = itemView.findViewById(R.id.imageThumb)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val resId = images[position]
        holder.thumb.setImageResource(resId)

        //onClick buscamos el ImageSwitcher en la vista raíz y cambiamos la imagen
        holder.itemView.setOnClickListener { v ->
            //opcion 1: getRootView()
            val root = v.rootView
            val imageSwitcher = root.findViewById<ImageSwitcher>(R.id.imageSwitcher)
            if (imageSwitcher != null) {
                imageSwitcher.setImageResource(resId)
                return@setOnClickListener
            }

            //fallback con Activity cast por si acaso
            val activity = v.context as? Activity
            activity?.findViewById<ImageSwitcher>(R.id.imageSwitcher)?.setImageResource(resId)
        }
    }
}
