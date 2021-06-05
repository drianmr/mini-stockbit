package com.drianmr.stockbit.mini.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drianmr.stockbit.mini.databinding.FragmentChatBinding
import com.drianmr.stockbit.mini.ui.base.BaseUiFragment

class ChatFragment : BaseUiFragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }
}
