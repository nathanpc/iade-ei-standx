package pt.iade.ei.standx.models

data class CarItem(
    val make: String,
    val model: String,
    val year: Int,
    val km: Int,
    val price: Float,
    val transmission: String,
    val fuel: String,
    val seats: Int,
    val id: Int = 0
)
