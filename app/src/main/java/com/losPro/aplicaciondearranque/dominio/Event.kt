package data

data class Event(
    val id: Long,
    val date: String,
    val hour: String,
    val place: String,
    val price: Double,
    val sport: Sport
)
