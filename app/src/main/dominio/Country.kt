package data

data class Country(
    val id: Long,
    val name: String,
    val position: String,
    val flag: String,
    val goldMedals: Int,
    val silverMedals: Int,
    val bronzeMedals: Int
)