package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.dominio.data.PurchaseAdapter
import repositories.PurchaseRepository


class PurchaseHistory : Fragment() {

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.fragment_purchase_history, container, false)
   }


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      val recyclerViewEvents = view.findViewById<RecyclerView>(R.id.recyclerViewPurchasesHistory)
      recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
      recyclerViewEvents.adapter = PurchaseAdapter(PurchaseRepository.get())


      val callback = object : OnBackPressedCallback(true) {
         override fun handleOnBackPressed() {
            findNavController().navigate(R.id.activity_main) // Back to activity_main
         }
      }
      requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
   }


}


////Redirect to Purchase History
//fun loadFragmentPurchaseHistory(view: View){
//   setContentView(R.layout.fragment_purchase_history)
//
//   val callback = object : OnBackPressedCallback(true) {
//      override fun handleOnBackPressed() {
//         //Back to activity_main
//         mainActivity()
//      }
//   }
//}