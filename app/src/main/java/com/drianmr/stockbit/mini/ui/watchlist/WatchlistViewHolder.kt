package com.drianmr.stockbit.mini.ui.watchlist

import androidx.recyclerview.widget.RecyclerView
import com.drianmr.stockbit.mini.databinding.ItemWatchlistBinding
import com.drianmr.stockbit.mini.model.Coin

class WatchlistViewHolder(
    private val binding: ItemWatchlistBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Coin) {
        binding.textViewName.text = data.info.name
        binding.textViewFullName.text = data.info.fullName
        // TODO: Format
        binding.textViewPrice.text = data.raw?.idr?.price?.toString() ?: "0.0"
        binding.textViewChangeDay.text = data.raw?.idr?.changeDay?.toString() ?: "0.0 (0%)"
    }
}
