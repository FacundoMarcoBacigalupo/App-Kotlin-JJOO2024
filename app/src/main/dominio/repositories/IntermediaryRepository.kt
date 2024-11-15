package repositories
import data.Elite
import data.Intermediary
import data.TicketPro
import data.UltimateEvent

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