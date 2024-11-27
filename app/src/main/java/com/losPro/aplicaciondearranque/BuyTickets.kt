package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.MainActivity.CurrentUser.currentUser
import com.losPro.aplicaciondearranque.dominio.data.Event
import com.losPro.aplicaciondearranque.dominio.data.EventButtonsAdapter
import com.losPro.aplicaciondearranque.dominio.data.Intermediary
import com.losPro.aplicaciondearranque.dominio.data.Purchase
import com.losPro.aplicaciondearranque.dominio.repositories.IntermediaryRepository
import com.losPro.aplicaciondearranque.dominio.repositories.PurchaseService
import repositories.EventRepository
import repositories.PurchaseRepository
import repositories.UserRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.round

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

       buyTickets(view)

   }

    private fun buyTickets(view: View) {

        //choose one event in the recycler view
        val recyclerViewEvents = view.findViewById<RecyclerView>(R.id.recyclerViewEvents)
        recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
        val adapter = EventButtonsAdapter(EventRepository.getEvents()) { event: Event ->

            val intermediaryView = showIntermediaryOptions(view)

            val buttonIntermediary1: Button =
                intermediaryView.findViewById(R.id.button_intermediary_pro)
            buttonIntermediary1.setOnClickListener {
                showConfirmPurchase(event, IntermediaryRepository.get()[0]) {
                    val rootContainer =
                        view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
                    rootContainer.removeView(intermediaryView)
                }
            }

            val buttonIntermediary2: Button =
                intermediaryView.findViewById(R.id.button_intermediary_elite)
            buttonIntermediary2.setOnClickListener {
                showConfirmPurchase(event, IntermediaryRepository.get()[1]) {
                    val rootContainer =
                        view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
                    rootContainer.removeView(intermediaryView)
                }
            }

            val buttonIntermediary3: Button =
                intermediaryView.findViewById(R.id.button_intermediary_ultimate_event)
            buttonIntermediary3.setOnClickListener {
                showConfirmPurchase(event, IntermediaryRepository.get()[2]) {
                    val rootContainer =
                        view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)
                    rootContainer.removeView(intermediaryView)
                }
            }
        }

        recyclerViewEvents.adapter = adapter
    }

    private var chosenSeat = PurchaseRepository.randomSeat()

   private fun showConfirmPurchase(event: Event, intermediary: Intermediary, onClose: () -> Unit) {
      val builder = AlertDialog.Builder(requireContext())
      builder.setMessage(
          """
   Ticket price: ${event.price}$
   Commission: $intermediary, ${intermediary.calculateCommission(event.price).round(2)}$
   Final price: ${PurchaseService.calculateFinalPrice(event.price,intermediary).round(2)}$
   Event: ${event.sport.name}
   Date: ${event.date}
   Place: ${event.place}
   Hour: ${event.hour}
   Seat: $chosenSeat
      """.trimMargin())
         .setTitle("Do you want to confirm the purchase?")
         .setPositiveButton("Confirm") { dialog, _ ->

           if (verifyPurchase(event, intermediary)){
              Toast.makeText(requireContext(), "Purchase confirmed for ${event.sport.name}", Toast.LENGTH_SHORT).show()
           }
             else
               Toast.makeText(requireContext(), "ERROR: Insufficient funds for ${event.sport.name}", Toast.LENGTH_SHORT).show()

            dialog.dismiss()
            onClose()
         }
         .setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()

         }

      val dialog = builder.create()
      dialog.show()
   }

   private fun verifyPurchase(event: Event, intermediary: Intermediary): Boolean {
       var payable = false
       val cashToPaid = PurchaseService.calculateFinalPrice(event.price,intermediary)
     if ((currentUser?.money)!! >= cashToPaid) {
             //Create new Purchase

         UserRepository.getUser(currentUser!!.id)?.money = UserRepository.getUser(currentUser!!.id)?.money?.minus(cashToPaid)!!

             val seatChosen = chosenSeat
         val currentDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE)
             val newPurchase = Purchase(
                 id = PurchaseRepository.newIdPurchase(),
                 userId = currentUser!!.id,
                 eventId = event.id,
                 amount = PurchaseService.calculateFinalPrice(event.price, intermediary).round(2),
                 createdDate = currentDate,
                 seat = seatChosen
             )
             PurchaseRepository.add(newPurchase)

         payable = true
      }
      return payable
   }

   private fun showIntermediaryOptions(view: View) : View {

      val rootContainer = view.findViewById<FrameLayout>(R.id.fragment_show_intermediarys)

      val newView = layoutInflater.inflate(R.layout.intermediary_layout, rootContainer, false)

      rootContainer.addView(newView)

      return newView
   }

    private fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}
