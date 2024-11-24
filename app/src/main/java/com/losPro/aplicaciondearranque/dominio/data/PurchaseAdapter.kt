package com.losPro.aplicaciondearranque.dominio.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.R

class PurchaseAdapter(private val purchases :  List<Purchase>) :
    RecyclerView.Adapter<PurchaseAdapter.ViewHolder>(){

    class ViewHolder(purchaseView: View) : RecyclerView.ViewHolder(purchaseView){

        val id: TextView = purchaseView.findViewById(R.id.textViewId)
        val userId: TextView = purchaseView.findViewById(R.id.textViewUserId)
        val eventId: TextView = purchaseView.findViewById(R.id.textViewEventId)
        val amount: TextView = purchaseView.findViewById(R.id.textViewAmount)
        val createdDate: TextView = purchaseView.findViewById(R.id.textViewCreatedDate)
        val seat: TextView = purchaseView.findViewById(R.id.textViewSeat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val purchase = purchases[position]
        holder.id.text = purchase.id.toString()
        holder.userId.text = purchase.userId.toString()
        holder.eventId.text = purchase.eventId.toString()
        holder.amount.text = purchase.amount.toString()
        holder.createdDate.text = purchase.createdDate
        holder.seat.text = purchase.seat
    }

    override fun getItemCount(): Int = purchases.size
}