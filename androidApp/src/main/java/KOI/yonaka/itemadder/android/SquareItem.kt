package KOI.yonaka.itemadder.android

data class SquareItem(
    val id: String,
    val type: String = "Item",
    val name: String,
    val description: String? = null,
    val price: Double,

)

data class Variation(
    val id: String,
    val name: String,
    val price: Double
)

data class Item_data(
    val abbreviation: String,
    val description: String,
    val name: String,
    val variations: List<Variation>? = null

)
