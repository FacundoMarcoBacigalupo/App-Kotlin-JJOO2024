package com.losPro.aplicaciondearranque.dominio.data
import java.time.DayOfWeek
import java.time.LocalDate

class UltimateEvent : Intermediary("Ultimate Event", 0.75) {

   override fun calculateCommission(price: Double): Double {
      val currentDay = LocalDate.now().dayOfWeek

      return if (currentDay == DayOfWeek.SATURDAY || currentDay == DayOfWeek.SUNDAY) {
         price * 0.03
      }
      else {
         price * (baseCommission / 100) // Use the base commission if it's not Saturday or Sunday
      }
   }
}