package com.losPro.aplicaciondearranque.dominio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.R

class StringAdapter(
    private val stringList: List<String> // La lista de Strings a mostrar
) : RecyclerView.Adapter<StringAdapter.ViewHolder>() {

    // ViewHolder: Clase que representa una fila
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView666)
    }

    // Crear la vista para cada fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Usa un layout simple predefinido (android.R.layout.simple_list_item_1)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.string_layout, parent, false)
        return ViewHolder(view)
    }

    // Vincular datos con la vista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = stringList[position]
    }

    // Tamaño de la lista
    override fun getItemCount(): Int = stringList.size
}