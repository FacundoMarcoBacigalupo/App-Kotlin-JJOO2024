package com.losPro.aplicaciondearranque.dominio.data

class TicketPro : Intermediary("Ticket Pro", 2.0) {
   override fun calculateCommission(price: Double): Double {
      return price * (baseCommission / 100)
   }

}