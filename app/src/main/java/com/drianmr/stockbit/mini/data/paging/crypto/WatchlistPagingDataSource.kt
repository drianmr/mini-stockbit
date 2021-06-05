package com.drianmr.stockbit.mini.data.paging.crypto

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.drianmr.stockbit.mini.data.network.service.CryptoService
import com.drianmr.stockbit.mini.model.Coin

class WatchlistPagingDataSource(
    private val cryptoService: CryptoService,
) : PagingSource<Int, Coin>() {

    companion object {
        const val INITIAL_PAGE = 0
    }

    override fun getRefreshKey(state: PagingState<Int, Coin>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Coin> {
        val page = params.key ?: INITIAL_PAGE

        return try {
            val requestParams = mapOf(
                "tsym" to "IDR",
                "limit" to "${params.loadSize}",
                "page" to "$page",
            )

            val result = cryptoService.listCrypto(requestParams)

            LoadResult.Page(
                data = result.data,
                prevKey = if (page == INITIAL_PAGE) null else page - 1,
                nextKey = if (result.data.isEmpty()) null else page + 1,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
