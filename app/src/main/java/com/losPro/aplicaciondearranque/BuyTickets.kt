package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.dominio.data.Event
import com.losPro.aplicaciondearranque.dominio.data.EventButtonsAdapter
import com.losPro.aplicaciondearranque.dominio.data.Intermediary
import repositories.EventRepository
import repositories.IntermediaryRepository
import repositories.PurchaseService

class BuyTickets : Fragment() {

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.fragment_buy_tickets, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      val callback = object : OnBackPressedCallback(true) {
         override fun handleOnBackPressed() {
            //Back to Home
            findNavController().navigate(R.id.fragment_home)
         }
      }
      requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

      //choose one event in the recycler view
      val recyclerViewEvents = view.findViewById<RecyclerView>(R.id.recyclerViewEvents)
      recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
      val adapter = EventButtonsAdapter(EventRepository.getEvents()) { event: Event ->
         // Obtén la vista inflada
         val intermediaryView = showIntermediaryOptons(view)

         // Configura los botones en la vista inflada
         val buttonIntermediary1: Button = intermediaryView.findViewById(R.id.button_intermediary_pro)
         buttonIntermediary1.setOnClickListener {
            showExampleDialog(event, "Pro Event") {
               // Ocultar la vista inflada después de cerrar el diálogo
               val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
               rootContainer.removeView(intermediaryView)
            }
         }

         val buttonIntermediary2: Button = intermediaryView.findViewById(R.id.button_intermediary_elite)
         buttonIntermediary2.setOnClickListener {
            showExampleDialog(event, "Elite Event") {
               val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
               rootContainer.removeView(intermediaryView)
            }
         }

         val buttonIntermediary3: Button = intermediaryView.findViewById(R.id.button_intermediary_ultimate_event)
         buttonIntermediary3.setOnClickListener {
            showExampleDialog(event, "Ultimate Event") {
               val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
               rootContainer.removeView(intermediaryView)
            }
         }
      }

      recyclerViewEvents.adapter = adapter
   }

   private fun showExampleDialog(event: Event, intermediary: String, onClose: () -> Unit) {
      val builder = AlertDialog.Builder(requireContext())
      builder.setMessage("Final price: ${event.price}")
         .setTitle("Do you want to confirm the purchase?")
         .setPositiveButton("Confirm") { dialog, _ ->
            Toast.makeText(requireContext(), "Purchase confirmed for ${event.sport.name}", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            onClose() // Ejecuta la acción adicional
         }
         .setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            onClose() // Ejecuta la acción adicional
         }

      val dialog = builder.create()
      dialog.show()
   }


   private fun showIntermediaryOptons(view: View) : View {
      val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)

      // Infla una nueva vista
      val newView = layoutInflater.inflate(R.layout.intermediary_layout, rootContainer, false)

      // Configura o interactúa con la vista inflada si es necesario
      val buttonIntermediaryPro = newView.findViewById<TextView>(R.id.button_intermediary_pro)

      // Agrega la vista al contenedor
      rootContainer.addView(newView)

      // Devuelve la vista inflada
      return newView
   }

   private fun intermediaryPro(
      view: View,
      event: Event ) {

      //choose one intermediary in the recycler view
      var intermediary: Intermediary
      val buttonIntermediary1: Button = view.findViewById(R.id.button_intermediary_pro)
      buttonIntermediary1.setOnClickListener() {

         intermediary = IntermediaryRepository.get()[0]

         var price =  PurchaseService.calculateFinalPrice(event.price,intermediary)


       //     intermediary.calculateCommission(event.price)
        // val comision = intermediary.calculateCommission(event.price)
        //price += event.price.plus(comision)

        // Toast.makeText(requireContext(), "COSTO :  $price", Toast.LENGTH_SHORT).show()

         val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_confirm_purchase)
         // Infla una nueva vista
         val newView = layoutInflater.inflate(R.layout.confirm_purchase_layout , rootContainer, false)
         // Configura o interactúa con la vista inflada si es necesario
         val buttonIntermediaryPro = newView.findViewById<TextView>(R.id.button_confirm_purchase)
         buttonIntermediaryPro.setOnClickListener(){


            findNavController().navigate(R.id.fragment_home)

         }

         rootContainer.addView(newView)
      }
   }
}
