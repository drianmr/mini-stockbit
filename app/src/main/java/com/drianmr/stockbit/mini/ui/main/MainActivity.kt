package com.drianmr.stockbit.mini.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.drianmr.stockbit.mini.R
import com.drianmr.stockbit.mini.databinding.ActivityMainBinding
import com.drianmr.stockbit.mini.ext.findNavController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setup()
    }

    private fun init() {
        navController = findNavController(R.id.nav_host_fragment)
    }

    private fun setup() {
        setupNavController()
        setupToolbar()
        setupBottomNavigationView()
    }

    private fun setupNavController() {
        val bottomNavigationDestinationIds = intArrayOf(R.id.menu_watchlist)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigationView.isGone =
                (destination.id !in bottomNavigationDestinationIds)
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setupWithNavController(navController)
        setSupportActionBar(binding.toolbar)
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}
