package com.example.di_practica5_georgemanuel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class AdaptSolar(
    private val solarList: MutableList<SolarItem>
) : RecyclerView.Adapter<AdaptSolar.SolarViewHolder>() {

    inner class SolarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewSolar: ImageView = itemView.findViewById(R.id.imageViewSolar)
        val toolbar: Toolbar = itemView.findViewById(R.id.toolbarSolar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_solar, parent, false)
        return SolarViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolarViewHolder, position: Int) {
        val item = solarList[position]

        holder.imageViewSolar.setImageResource(item.imageResId)
        holder.toolbar.title = item.name

        // Inflar menú (asegúrate de hacerlo solo una vez por holder)
        holder.toolbar.menu.clear()
        holder.toolbar.inflateMenu(R.menu.menu_solar_item)

        // Listener para el menú overflow
        holder.toolbar.setOnMenuItemClickListener { menuItem ->
            val adapterPosition = holder.bindingAdapterPosition
            if (adapterPosition == RecyclerView.NO_POSITION) return@setOnMenuItemClickListener false

            when (menuItem.itemId) {
                R.id.action_copy -> {
                    // Copiar: crear una copia y añadir justo después
                    val originalItem = solarList[adapterPosition]
                    val copied = SolarItem(originalItem.name + " (Copia)", originalItem.imageResId)
                    solarList.add(adapterPosition + 1, copied)
                    notifyItemInserted(adapterPosition + 1)
                    true
                }
                R.id.action_delete -> {
                    // Eliminar
                    solarList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                    true
                }
                else -> false
            }
        }
    }

    override fun getItemCount(): Int = solarList.size
}
