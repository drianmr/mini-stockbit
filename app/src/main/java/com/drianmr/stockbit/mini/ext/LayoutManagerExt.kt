package com.drianmr.stockbit.mini.ext

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Create [LinearLayoutManager] with [LinearLayoutManager.VERTICAL] orientation.
 */
fun RecyclerView.verticalLayoutManager(): LinearLayoutManager =
    LinearLayoutManager(context)
