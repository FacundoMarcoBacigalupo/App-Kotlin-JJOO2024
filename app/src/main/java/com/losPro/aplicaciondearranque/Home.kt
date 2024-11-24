package com.losPro.aplicaciondearranque

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
      return inflater.inflate(R.layout.fragment_home, container, false)
   }


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      val buttonBuyTickets: Button = view.findViewById(R.id.button_buy_tickets)
      buttonBuyTickets.setOnClickListener {
         findNavController().navigate(R.id.action_home_to_fragment_buy_tickets)
      }

      val buttonViewAllMedals: Button = view.findViewById(R.id.button_view_all_medals)
      buttonViewAllMedals.setOnClickListener {
         findNavController().navigate(R.id.action_home_to_fragment_view_medals)
      }

      val buttonPurchaseHistory: Button = view.findViewById(R.id.button_purchase_history)
      buttonPurchaseHistory.setOnClickListener {
         findNavController().navigate(R.id.action_home_to_fragment_purchase_history)
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