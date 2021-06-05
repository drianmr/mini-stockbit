package com.drianmr.stockbit.mini.ext

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

fun Fragment.getColorCompat(@ColorRes color: Int): Int =
    ContextCompat.getColor(requireContext(), color)

fun RecyclerView.ViewHolder.getColorCompat(@ColorRes color: Int): Int =
    ContextCompat.getColor(itemView.context, color)
