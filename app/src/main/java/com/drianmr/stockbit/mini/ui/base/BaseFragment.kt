package com.drianmr.stockbit.mini.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment()

abstract class BaseUiFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return onCreateViewBinding(inflater, container)
    }

    abstract fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View
}
