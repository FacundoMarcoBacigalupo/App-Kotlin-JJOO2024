package com.losPro.aplicaciondearranque.dominio.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.R

class MedalsAdapter(private val medals: List<Pair<Country, Int>>) :
    RecyclerView.Adapter<MedalsAdapter.ViewHolder>() {

    class ViewHolder(medals: View) : RecyclerView.ViewHolder(medals){
        val id: TextView = medals.findViewById(R.id.textViewId)
        val position: TextView = medals.findViewById(R.id.textViewPosition)
        val goldMedals: TextView = medals.findViewById(R.id.textViewGoldMedals)
        val silverMedals: TextView = medals.findViewById(R.id.textViewSilverMedals)
        val bronzeMedals: TextView = medals.findViewById(R.id.textViewBronzeMedals)
        val totalMedals: TextView = medals.findViewById(R.id.textViewTotalMedals)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medals_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (country, totalMedals) = medals[position] // Destructure Pair
        holder.id.text = country.id.toString()
        holder.position.text = country.position
        holder.goldMedals.text = country.goldMedals.toString()
        holder.silverMedals.text = country.silverMedals.toString()
        holder.bronzeMedals.text = country.bronzeMedals.toString()
        holder.totalMedals.text = totalMedals.toString()
    }

    override fun getItemCount(): Int = medals.size
}
