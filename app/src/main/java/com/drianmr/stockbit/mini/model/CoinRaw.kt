package com.drianmr.stockbit.mini.model

import com.google.gson.annotations.SerializedName

data class CoinRaw(
    @SerializedName("IDR") val idr: Idr,
) {

    data class Idr(
        @SerializedName("PRICE")
        val price: Float,

        @SerializedName("CHANGEDAY")
        val changeDay: Float,
    )
}