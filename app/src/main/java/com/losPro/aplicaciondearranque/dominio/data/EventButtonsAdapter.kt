package com.losPro.aplicaciondearranque.dominio.data

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.losPro.aplicaciondearranque.R

class EventButtonsAdapter(private val events : List<Event>,
                          private val onButtonClick: (Event) -> Unit
    ) :
    RecyclerView.Adapter<EventButtonsAdapter.ViewHolder>(){
    class ViewHolder(eventView: View) : RecyclerView.ViewHolder(eventView){

            val id: TextView = eventView.findViewById(R.id.textViewId)
            val date: TextView = eventView.findViewById(R.id.textViewDate)
            val hour: TextView = eventView.findViewById(R.id.textViewHour)
            val place: TextView = eventView.findViewById(R.id.textViewPlace)
            val price: TextView = eventView.findViewById(R.id.textViewPrice)
            val sport: TextView = eventView.findViewById(R.id.textViewSport)
            val buttonTest: Button = eventView.findViewById(R.id.buttonTest)
            val stars: TextView = eventView.findViewById(R.id.textViewStars)
            val logo: ImageView = eventView.findViewById(R.id.imageViewLogo)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.event_buttons_layout,parent,false)
      return ViewHolder(view)
    }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]
       // holder.id.text = event.id.toString()
      //  holder.date.text = event.date
      //  holder.hour.text = event.hour
      //  holder.place.text = event.place
        holder.price.text = "$${event.price}"
        //holder.sport.text = event.sport.toString()
        holder.sport.text= event.sport.name
        holder.stars.text= "${event.sport.stars}★"
       // holder.id.text = "${event.id} ★"
          holder.date.text = "Date: ${event.date}"
         holder.hour.text = "Hour: ${event.hour}"
        holder.place.text = "Place: ${event.place}"

      Glide.with(holder.logo.context)
          .load(event.sport.logo)
          .into(holder.logo)

      holder.buttonTest.setOnClickListener(){
          onButtonClick(event)
      }
    }

    override fun getItemCount(): Int = events.size
}