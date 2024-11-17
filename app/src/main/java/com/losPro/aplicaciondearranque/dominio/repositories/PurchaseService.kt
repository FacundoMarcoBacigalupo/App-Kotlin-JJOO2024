package repositories
import com.losPro.aplicaciondearranque.dominio.data.Intermediary

object PurchaseService {
   fun calculateFinalPrice(price: Double, intermediary: Intermediary): Double {
      val condition = intermediary.calculateCommission(price)
      return price.plus(condition)
   }


}