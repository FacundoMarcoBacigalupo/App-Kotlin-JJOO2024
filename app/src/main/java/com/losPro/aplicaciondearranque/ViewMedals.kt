package com.losPro.aplicaciondearranque;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.dominio.data.EventAdapter
import repositories.EventRepository

class ViewMedals : Fragment() {

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.fragment_view_medals, container, false)
   }


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)


      val recyclerViewEvents = view.findViewById<RecyclerView>(R.id.recyclerViewPurchases)
      recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
      recyclerViewEvents.adapter = EventAdapter(EventRepository.getEvents())
   }
}


////Redirect to View All Medals
//fun loadFragmentViewMedals(view: View) {
//   setContentView(R.layout.fragment_view_medals)
//
//   val recyclerViewEvents = findViewById<RecyclerView>(R.id.recyclerViewPurchases)
//   recyclerViewEvents.layoutManager = LinearLayoutManager(this)
//   recyclerViewEvents.adapter = EventAdapter(EventRepository.getEvents())
//}