package com.drianmr.stockbit.mini.data.network.service

import com.drianmr.stockbit.mini.data.network.response.BaseResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CryptoService {

    @GET("top/totaltoptiervolfull")
    suspend fun listCrypto(@QueryMap params: Map<String, String>): BaseResponse
}
