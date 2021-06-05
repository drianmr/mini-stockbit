package com.drianmr.stockbit.mini.ui.watchlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drianmr.stockbit.mini.databinding.FragmentWatchlistBinding
import com.drianmr.stockbit.mini.ui.base.BaseUiFragment

class WatchlistFragment : BaseUiFragment() {

    private var _binding: FragmentWatchlistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        return binding.root
    }
}
