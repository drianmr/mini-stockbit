package com.drianmr.stockbit.mini.ext

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

fun FragmentActivity.findNavController(@IdRes id: Int): NavController =
    (supportFragmentManager.findFragmentById(id) as? NavHostFragment)?.navController
        ?: findNavController(id)
