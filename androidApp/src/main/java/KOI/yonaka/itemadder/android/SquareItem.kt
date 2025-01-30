package KOI.yonaka.itemadder.android

data class SquareItem(
    val id: String,
    val name: String,
    val description: String? = null,
    val price: Double,
    val variations: List<Variation>? = null
)

data class Variation(
    val id: String,
    val name: String,
    val price: Double
)
