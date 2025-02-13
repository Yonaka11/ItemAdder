package KOI.yonaka.itemadder.android

import com.google.gson.annotations.SerializedName


class DefaultItem  {

    data class ApiResponse(
        @SerializedName("idempotency_key")
        val idempotencyKey:String = "nxjnkjnakxja",
        @SerializedName("object")
        val objectData: ObjectData
    )

    data class ObjectData(
        val id: String = "1121245",
        val type: String = "test type",
        @SerializedName("item_data")
        val itemData: ItemData
    )

    data class ItemData(
        val abbreviation: String = "T1",
        val description: String = "A friendly test item",
        val name: String = "I name goe here",
        val variations: List<Variation>

    )

    data class Variation(
        val id: String = "var id goes here",
        val type: String = "var type goes here",
        @SerializedName("item_variation_data")
        val itemVariationData: ItemVariationData
    )

    data class ItemVariationData(
        @SerializedName("item_id")
        val itemId: String = "IV id ????",
        val name: String = "iv name ",
        @SerializedName("pricing_type")
        val pricingType: String = "norm",
        @SerializedName("price_money")
        val priceMoney: PriceMoney? = null // Optional, as it's not present in all variations.
    )

    data class PriceMoney(
        val amount: Int,
        val currency: String
    )
}