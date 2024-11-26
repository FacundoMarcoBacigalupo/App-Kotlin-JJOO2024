package repositories
import com.losPro.aplicaciondearranque.dominio.data.Event


object
EventRepository {
   private val events = mutableListOf<Event>()

   init {
      events.add(
         Event(
            1L,
            "2024/07/02",
            "10:30",
            "PSG Stadium",
            150000.00,
            SportRepository.getFootball()
         )
      )

      events.add(
         Event(
            2L,
            "2024-07-12",
            "15:00",
            "Olympic Arena",
            200500.75,
            SportRepository.getBasketball()
         )
      )

      events.add(
         Event(
            3L,
            "2024-07-25",
            "18:45",
            "National Stadium",
            119000.99,
            SportRepository.getAthletics()
         )
      )

      events.add(
         Event(
            4L,
            "2024-07-30",
            "12:00",
            "Main Arena",
            180999.20,
            SportRepository.getSwimming()
         )
      )

      events.add(
         Event(
            5L,
            "2024-08-01",
            "20:30",
            "City Sports Complex",
            161500.45,
            SportRepository.getGymnastics()
         )
      )

      events.add(
         Event(
            6L,
            "2024-08-07",
            "17:00",
            "Regional Stadium",
            140250.10,
            SportRepository.getCycling()
         )
      )

      events.add(
         Event(
            7L,
            "2024-08-10",
            "14:00",
            "Victory Stadium",
            130125.35,
            SportRepository.getRowing()
         )
      )

      events.add(
         Event(
            8L,
            "2024-08-15",
            "16:30",
            "Championship Arena",
            190750.85,
            SportRepository.getFencing()
         )
      )

      events.add(
         Event(
            9L,
            "2024-08-18",
            "11:15",
            "International Stadium",
            175300.99,
            SportRepository.getJudo()
         )
      )

      events.add(
         Event(
            10L,
            "2024-08-25",
            "13:45",
            "Olympic Park",
            210000.70,
            SportRepository.getTennis()
         )
      )
   }

   fun getEvents(): List<Event> {
      return events
   }

   fun get() : List<Event> {
      val newListEvents = mutableListOf<Event>()

      events.forEach { event ->
         newListEvents.add( Event(
            event.id,
            event.date,
            event.hour,
            event.place,
            event.price,
            event.sport
         ) )
      }

      return newListEvents
   }

   fun getById(id: Long) : Event? {
      return events.find { it.id == id }
   }

   fun getByName(name: String) : Event? {
      return events.find { it.sport.name == name }
   }

}