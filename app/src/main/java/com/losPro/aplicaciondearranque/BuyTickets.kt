package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.dominio.data.Event
import com.losPro.aplicaciondearranque.dominio.data.EventButtonsAdapter
import repositories.EventRepository


class BuyTickets : Fragment() {

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.fragment_buy_tickets, container, false)
   }


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)


      var eventChoosed: Event
      //choose one event in the recycler view
      val recyclerViewEvents = view.findViewById<RecyclerView>(R.id.recyclerViewEvents)
      recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
      val adapter = EventButtonsAdapter(EventRepository.getEvents()) { event: Event ->
         Toast.makeText(requireContext(), "You touched: $event", Toast.LENGTH_SHORT).show()
         eventChoosed = event
      }
      recyclerViewEvents.adapter = adapter


      val callback = object : OnBackPressedCallback(true) {
         override fun handleOnBackPressed() {
            //Back to Home
            findNavController().navigate(R.id.activity_home)
         }
      }
      requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
   }
}



////Redirect to Buy Tickets
//private fun loadFragmentBuyTickets() {
//   setContentView(R.layout.fragment_buy_tickets)
//
//   var eventChoosed : Event
//   //choose one event in the recycler view
//   val recyclerViewEvents = findViewById<RecyclerView>(R.id.recyclerViewEvents)
//   recyclerViewEvents.layoutManager = LinearLayoutManager(this)
//   val adapter = EventButtonsAdapter(EventRepository.getEvents()){ event: Event ->
//
//      Toast.makeText(this, "You touched: $event", Toast.LENGTH_SHORT).show()
//      eventChoosed = event
//   }
//
//
//   recyclerViewEvents.adapter = adapter
//
//
//   val callback = object : OnBackPressedCallback(true) {
//      override fun handleOnBackPressed() {
//         //Back to activity_main2
//         loadActivityMain2()
//      }
//   }
//   onBackPressedDispatcher.addCallback(this, callback)
//}