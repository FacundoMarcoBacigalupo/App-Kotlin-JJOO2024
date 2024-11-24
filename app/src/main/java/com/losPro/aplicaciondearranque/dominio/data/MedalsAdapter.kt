package com.losPro.aplicaciondearranque.dominio.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.R

class MedalsAdapter(private val medals: Map<Country, Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(purchaseView: View) : RecyclerView.ViewHolder(purchaseView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.purchase_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = medals.size
}
