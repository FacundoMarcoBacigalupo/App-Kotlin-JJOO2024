package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController

class Home : Fragment() {

   class SharedViewModel : ViewModel() {
      private val _data = MutableLiveData<String>()
      val data: LiveData<String> = _data

   }
   private val viewModel: SharedViewModel by activityViewModels()

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.fragment_home, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      viewModel.data.observe(viewLifecycleOwner) {

      }

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
      val buttonExit: Button = view.findViewById(R.id.button_exit)
      buttonExit.setOnClickListener {
         findNavController().navigate(R.id.action_home_to_fragment_login)
      }



   }
}
