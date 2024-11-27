package com.losPro.aplicaciondearranque.dominio.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.R
import repositories.EventRepository

class PurchaseAdapter(private val purchases :  List<Purchase>) :
    RecyclerView.Adapter<PurchaseAdapter.ViewHolder>(){

    class ViewHolder(purchaseView: View) : RecyclerView.ViewHolder(purchaseView){
        val id: TextView = purchaseView.findViewById(R.id.textViewId)
        val eventId: TextView = purchaseView.findViewById(R.id.textViewEventId)
        val amount: TextView = purchaseView.findViewById(R.id.textViewAmount)
        val createdDate: TextView = purchaseView.findViewById(R.id.textViewCreatedDate)
        val seat: TextView = purchaseView.findViewById(R.id.textViewSeat)
        var eventDate: TextView = purchaseView.findViewById(R.id.textViewEventDate)
        var eventHour: TextView = purchaseView.findViewById(R.id.textViewEventHour)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.purchase_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val purchase = purchases[position]
        val eventName = EventRepository.getById(purchase.eventId)

        holder.id.text = "ID: ${purchase.id}"
        holder.eventId.text = "Event: ${eventName?.sport?.name}"
        holder.amount.text = "Amount: $${purchase.amount}"
        holder.createdDate.text = "Purchase Date: ${purchase.createdDate}"
        holder.seat.text = "Seat: ${purchase.seat}"
        holder.eventDate.text = "Event Date: ${eventName?.date}"
        holder.eventHour.text = "Event Hour: ${eventName?.hour}"
    }

    override fun getItemCount(): Int = purchases.size
}