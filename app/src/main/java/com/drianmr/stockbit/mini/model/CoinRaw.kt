package com.drianmr.stockbit.mini.model

import com.google.gson.annotations.SerializedName

data class CoinRaw(val idr: Idr) {

    data class Idr(
        @SerializedName("VOLUME")
        val price: Float,

        @SerializedName("CHANGEDAY")
        val changeDay: Float,
    )
}