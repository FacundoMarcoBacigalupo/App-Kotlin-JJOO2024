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
import com.losPro.aplicaciondearranque.dominio.data.MedalsAdapter
import repositories.MedalTableRepository

class ViewMedals : Fragment() {

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.fragment_view_medals, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      val recyclerViewEvents = view.findViewById<RecyclerView>(R.id.recyclerViewMedals)
      recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())

      val medalsList = MedalTableRepository.get().toList()
      recyclerViewEvents.adapter = MedalsAdapter(medalsList)

       val callback = object : OnBackPressedCallback(true) {
         override fun handleOnBackPressed() {
            findNavController().navigate(R.id.fragment_home) // Back to fragment_home
         }
      }
      requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
   }
}