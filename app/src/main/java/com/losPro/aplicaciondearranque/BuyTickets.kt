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
import com.losPro.aplicaciondearranque.dominio.data.Purchase
import repositories.EventRepository
import repositories.IntermediaryRepository
import repositories.PurchaseRepository
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

         val intermediaryView = showIntermediaryOptons(view)

         val buttonIntermediary1: Button = intermediaryView.findViewById(R.id.button_intermediary_pro)
         buttonIntermediary1.setOnClickListener {
            showConfirmPurchase(event, IntermediaryRepository.get()[0]) {
              val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
                rootContainer.removeView(intermediaryView)
            }
         }

         val buttonIntermediary2: Button = intermediaryView.findViewById(R.id.button_intermediary_elite)
         buttonIntermediary2.setOnClickListener {
            showConfirmPurchase(event, IntermediaryRepository.get()[1]) {
               val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
               rootContainer.removeView(intermediaryView)
            }
         }

         val buttonIntermediary3: Button = intermediaryView.findViewById(R.id.button_intermediary_ultimate_event)
         buttonIntermediary3.setOnClickListener {
            showConfirmPurchase(event, IntermediaryRepository.get()[2]) {
               val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
               rootContainer.removeView(intermediaryView)
            }
         }
      }

      recyclerViewEvents.adapter = adapter
   }

   private fun showConfirmPurchase(event: Event, intermediary: Intermediary, onClose: () -> Unit) {
      val builder = AlertDialog.Builder(requireContext())
      val seat= PurchaseRepository.randomSeat()
      builder.setMessage("""
      Ticket price: ${event.price}
      Commission: ${intermediary.calculateCommission(event.price)}
      Final price: ${PurchaseService.calculateFinalPrice(event.price,intermediary)}
      Event: ${event.sport.name}
      Date: ${event.date}
      Place: ${event.place}
      Hour: ${event.hour}
      Seat: ${seat.toString()}
      """.trimMargin())
         .setTitle("Do you want to confirm the purchase?")
         .setPositiveButton("Confirm") { dialog, _ ->

           if (verifyPurchase(event, intermediary)){

              Toast.makeText(requireContext(), "Purchase confirmed for ${event.sport.name}", Toast.LENGTH_SHORT).show()
           }

            dialog.dismiss()
            onClose()
         }
         .setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            onClose()
         }

      val dialog = builder.create()
      dialog.show()
   }

   private fun verifyPurchase(event: Event, intermediary: Intermediary): Boolean {

      //  if ((currentUser?.money)!! >= finalPrice) {
      //    //Create new Purchase
      //  val newPurchase = Purchase(
      //    id = PurchaseRepository.newIdPurchase(),
      //    userId = currentUser!!.id,
      //    eventId = eventChooseForName.id,
      //    amount = finalPrice,
      //    createdDate = currentDate,
      //    seat = seat
      //  )

      //  PurchaseRepository.add(purchase)

      return true
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
}
