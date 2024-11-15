package data

abstract class Intermediary (val name: String, val baseCommission: Double) {

   abstract fun calculateCommission(price: Double): Double

}

