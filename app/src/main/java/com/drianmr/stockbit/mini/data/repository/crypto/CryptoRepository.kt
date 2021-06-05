package com.drianmr.stockbit.mini.data.repository.crypto

import com.drianmr.stockbit.mini.data.Result
import com.drianmr.stockbit.mini.data.network.response.BaseResponse
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    fun getListCrypto(params: Map<String, String>): Flow<Result<BaseResponse>>
}
