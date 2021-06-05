package com.drianmr.stockbit.mini.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drianmr.stockbit.mini.databinding.FragmentSearchBinding
import com.drianmr.stockbit.mini.ui.base.BaseUiFragment

class SearchFragment : BaseUiFragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
}
