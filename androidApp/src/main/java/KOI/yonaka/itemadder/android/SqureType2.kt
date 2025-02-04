package KOI.yonaka.itemadder.android
import com.google.gson.annotations.SerializedName

class SqureType2 {


    data class ApiResponse(
        @SerializedName("idempotency_key")
        val idempotencyKey: String,
        @SerializedName("object")
        val objectData: ObjectData
    )

    data class ObjectData(
        val id: String,
        val type: String,
        @SerializedName("item_data")
        val itemData: ItemData
    )

    data class ItemData(
        val abbreviation: String,
        val description: String,
        val name: String,
        val variations: List<Variation>
    )

    data class Variation(
        val id: String,
        val type: String,
        @SerializedName("item_variation_data")
        val itemVariationData: ItemVariationData
    )

    data class ItemVariationData(
        @SerializedName("item_id")
        val itemId: String,
        val name: String,
        @SerializedName("pricing_type")
        val pricingType: String,
        @SerializedName("price_money")
        val priceMoney: PriceMoney? = null // Optional, as it's not present in all variations.
    )

    data class PriceMoney(
        val amount: Int,
        val currency: String
    )
}