package com.drianmr.stockbit.mini.ui.watchlist

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.drianmr.stockbit.mini.databinding.ItemWatchlistBinding
import com.drianmr.stockbit.mini.ext.inflater
import com.drianmr.stockbit.mini.model.Coin
import com.drianmr.stockbit.mini.model.comparator.CoinComparator
import javax.inject.Inject

class WatchlistAdapter @Inject constructor() :
    PagingDataAdapter<Coin, WatchlistViewHolder>(CoinComparator()) {

    override fun onBindViewHolder(holder: WatchlistViewHolder, position: Int) {
        val data = getItem(position)

        if (data != null) {
            holder.bind(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistViewHolder {
        val binding = ItemWatchlistBinding.inflate(parent.inflater, parent, false)
        return WatchlistViewHolder(binding)
    }
}