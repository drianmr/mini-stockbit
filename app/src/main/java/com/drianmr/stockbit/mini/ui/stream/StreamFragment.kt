package com.drianmr.stockbit.mini.ui.stream

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drianmr.stockbit.mini.databinding.FragmentStreamBinding
import com.drianmr.stockbit.mini.ui.base.BaseUiFragment

class StreamFragment : BaseUiFragment() {

    private var _binding: FragmentStreamBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentStreamBinding.inflate(inflater, container, false)
        return binding.root
    }
}
