package com.drianmr.stockbit.mini.ui.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drianmr.stockbit.mini.databinding.FragmentLoginBinding
import com.drianmr.stockbit.mini.ui.base.BaseUiFragment

class LoginFragment : BaseUiFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
}
