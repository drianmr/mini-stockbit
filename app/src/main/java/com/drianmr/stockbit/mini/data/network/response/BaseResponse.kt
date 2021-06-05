package com.drianmr.stockbit.mini.data.network.response

import com.drianmr.stockbit.mini.model.Coin

data class BaseResponse(
    val message: String,
    val data: List<Coin>,
)
