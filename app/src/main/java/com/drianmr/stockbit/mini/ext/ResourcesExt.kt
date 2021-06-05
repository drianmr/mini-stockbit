package com.drianmr.stockbit.mini.ext

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.getColorCompat(@ColorRes color: Int): Int =
    ContextCompat.getColor(requireContext(), color)
