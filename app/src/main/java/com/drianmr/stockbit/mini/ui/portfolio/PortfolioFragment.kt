package com.drianmr.stockbit.mini.ui.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drianmr.stockbit.mini.databinding.FragmentPortfolioBinding
import com.drianmr.stockbit.mini.ui.base.BaseUiFragment

class PortfolioFragment : BaseUiFragment() {

    private var _binding: FragmentPortfolioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentPortfolioBinding.inflate(inflater, container, false)
        return binding.root
    }
}
