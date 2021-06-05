package com.drianmr.stockbit.mini.model

import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("CoinInfo")
    val info: CoinInfo,

    @SerializedName("RAW")
    val raw: CoinRaw,
)
