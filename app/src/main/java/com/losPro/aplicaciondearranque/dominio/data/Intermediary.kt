package com.losPro.aplicaciondearranque.dominio.data

abstract class Intermediary (val name: String, val baseCommission: Double) {

   abstract fun calculateCommission(price: Double): Double

   override fun toString(): String {
      return name
   }
}

