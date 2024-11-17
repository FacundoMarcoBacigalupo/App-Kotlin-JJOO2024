package com.losPro.aplicaciondearranque.dominio.data
import java.time.LocalTime

class Elite : Intermediary("Elite", 3.0) {

   override fun calculateCommission(price: Double): Double {
      val currentHour = LocalTime.now().hour

      return if (currentHour in 20..23) {
         price * 0.01
      }
      else {
         price * (baseCommission / 100) // Use the base commission if it's not between 20 and 23 hs
      }
   }
}