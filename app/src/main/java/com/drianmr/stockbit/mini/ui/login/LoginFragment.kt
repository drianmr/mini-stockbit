package com.drianmr.stockbit.mini.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import androidx.navigation.Navigation
import com.drianmr.stockbit.mini.R
import com.drianmr.stockbit.mini.databinding.FragmentLoginBinding
import com.drianmr.stockbit.mini.ext.getColorCompat
import com.drianmr.stockbit.mini.ui.base.BaseUiFragment

class LoginFragment : BaseUiFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {
        setupRegisterButton()

        binding.buttonLogin.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                LoginFragmentDirections.actionLoginFragmentToWatchlistFragment()
            )
        )
    }

    private fun setupRegisterButton() {
        val black = getColorCompat(R.color.black_text)
        val brand = getColorCompat(R.color.brand)

        val text = getString(R.string.action_dont_have_account)
        val text1 = text.substring(0, text.indexOf('?') + 1)
        val text2 = text.substring(text.indexOf('?') + 1, text.length)

        binding.buttonRegister.text = buildSpannedString {
            color(black) { append(text1) }
            color(brand) { append(text2) }
        }
    }
}
