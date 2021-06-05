package com.drianmr.stockbit.mini.ui.watchlist

import androidx.recyclerview.widget.RecyclerView
import com.drianmr.stockbit.mini.R
import com.drianmr.stockbit.mini.databinding.ItemWatchlistBinding
import com.drianmr.stockbit.mini.ext.getColorCompat
import com.drianmr.stockbit.mini.ext.resources
import com.drianmr.stockbit.mini.model.Coin
import java.text.DecimalFormat
import kotlin.math.abs

class WatchlistViewHolder(
    private val binding: ItemWatchlistBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Coin) {
        val rawPrice = data.raw?.idr?.price ?: 0f
        val rawChangeDay = data.raw?.idr?.changeDay ?: 0f

        val rawChangeDayPercentage =
            if (abs(rawPrice) > 0f && abs(rawChangeDay) > 0) {
                (rawChangeDay / rawPrice) * 100
            } else {
                0f
            }

        binding.textViewName.text = data.info.name
        binding.textViewFullName.text = data.info.fullName
        binding.textViewPrice.text = formatDecimal(rawPrice)
        binding.textViewChangeDay.text =
            resources.getString(
                R.string.template_change_day,
                formatDecimal(rawChangeDay, withPlus = true),
                formatDecimal(rawChangeDayPercentage, withPlus = true),
            )

        binding.textViewChangeDay.setTextColor(getColorCompat(
            when {
                rawChangeDay > 0f -> R.color.brand
                rawChangeDay < 0f -> R.color.red
                else -> R.color.grey
            }
        ))
    }

    private fun formatDecimal(price: Float, withPlus: Boolean = false): String {
        val value = DecimalFormat("#,###.#").format(price)

        if (withPlus) {
            return if (price > 0f) "+$value" else value
        }

        return value
    }
}
