package repositories
import com.losPro.aplicaciondearranque.dominio.data.Elite
import com.losPro.aplicaciondearranque.dominio.data.Intermediary
import com.losPro.aplicaciondearranque.dominio.data.TicketPro
import com.losPro.aplicaciondearranque.dominio.data.UltimateEvent

object IntermediaryRepository {
    private val intermediates = listOf( TicketPro(), Elite(), UltimateEvent() )

   //Lambda
   val get: () -> List<Intermediary> = { intermediates }

   fun showIntermediates() {
      println("INTERMEDIARY")
      println("--------------------")
      intermediates.forEachIndexed { index, intermediary ->
         println("${index + 1}. ${intermediary.name} his commission is ${intermediary.baseCommission}%" )
      }
   }
}