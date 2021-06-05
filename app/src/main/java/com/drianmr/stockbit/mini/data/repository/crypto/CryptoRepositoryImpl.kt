package com.drianmr.stockbit.mini.data.repository.crypto

import com.drianmr.stockbit.mini.data.Result
import com.drianmr.stockbit.mini.data.network.response.BaseResponse
import com.drianmr.stockbit.mini.data.network.service.CryptoService
import com.drianmr.stockbit.mini.ext.fetchFromNetwork
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoService: CryptoService,
) : CryptoRepository {

    override fun getListCrypto(params: Map<String, String>): Flow<Result<BaseResponse>> =
        fetchFromNetwork {
            cryptoService.listCrypto(params)
        }
}
