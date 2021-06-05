package com.drianmr.stockbit.mini.ui.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.drianmr.stockbit.mini.data.network.service.CryptoService
import com.drianmr.stockbit.mini.data.paging.crypto.WatchlistPagingDataSource
import com.drianmr.stockbit.mini.model.Coin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val cryptoService: CryptoService,
) : ViewModel() {

    val listCrypto: Flow<PagingData<Coin>> =
        Pager(
            config = PagingConfig(pageSize = 50, prefetchDistance = 1, initialLoadSize = 50),
            pagingSourceFactory = {
                WatchlistPagingDataSource(cryptoService)
            }
        ).flow.cachedIn(viewModelScope)
}
