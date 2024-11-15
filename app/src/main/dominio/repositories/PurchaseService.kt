package repositories
import data.Intermediary

object PurchaseService {
   fun calculateFinalPrice(price: Double, intermediary: Intermediary): Double {
      val condition = intermediary.calculateCommission(price)
      return price.plus(condition)
   }


}