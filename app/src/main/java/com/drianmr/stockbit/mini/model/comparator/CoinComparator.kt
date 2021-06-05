package com.drianmr.stockbit.mini.model.comparator

import androidx.recyclerview.widget.DiffUtil
import com.drianmr.stockbit.mini.model.Coin

class CoinComparator : DiffUtil.ItemCallback<Coin>() {

    override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean =
        oldItem.info.id == newItem.info.id

    override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean =
        oldItem.info == newItem.info && oldItem.raw == newItem.raw
}
