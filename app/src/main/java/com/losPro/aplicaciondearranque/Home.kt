package com.losPro.aplicaciondearranque;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Home : Fragment() {

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.activity_home, container, false)
   }


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)


      val buttonBuyTickets: Button = view.findViewById(R.id.button_buy_tickets)
      buttonBuyTickets.setOnClickListener {
         findNavController().navigate(R.id.action_home_to_fragment_buy_tickets)
      }


   }
}


////Redirect to Home
//private fun loadActivityMain2() {
//   setContentView(R.layout.activity_home)
//
//   val buttonBuyTickets : Button = findViewById(R.id.button_buy_tickets)
//   buttonBuyTickets.setOnClickListener{
//      loadFragmentBuyTickets()
//   }
//
//   val buttonExit : Button = findViewById(R.id.button_go_from_main2_to_main)
//   buttonExit.setOnClickListener{mainActivity()}
//
//}