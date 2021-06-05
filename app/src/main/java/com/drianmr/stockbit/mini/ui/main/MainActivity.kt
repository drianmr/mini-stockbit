package com.drianmr.stockbit.mini.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.drianmr.stockbit.mini.R
import com.drianmr.stockbit.mini.databinding.ActivityMainBinding
import com.drianmr.stockbit.mini.ext.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navGraph: NavGraph

    private val topLevelDestination = intArrayOf(
        R.id.menu_watchlist,
        R.id.menu_stream,
        R.id.menu_search,
        R.id.menu_chat,
        R.id.menu_portfolio,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setup()
    }

    private fun init() {
        navController = findNavController(R.id.nav_host_fragment)
        navGraph = navController.navInflater.inflate(R.navigation.nav_graph_main)
    }

    private fun setup() {
        setupNavController()
        setupToolbar()
        setupBottomNavigationView()
    }

    private fun setupNavController() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigationView.isGone =
                (destination.id !in topLevelDestination)

            // Update start destination
            if (destination.id in topLevelDestination) {
                if (navGraph.startDestination != R.id.menu_watchlist) {
                    navGraph.startDestination = R.id.menu_watchlist
                    navController.graph = navGraph
                }
            }
        }
    }

    private fun setupToolbar() {
        val appBarConfiguration =
            AppBarConfiguration.Builder(R.id.fragment_login, *topLevelDestination)
                .build()

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        setSupportActionBar(binding.toolbar)
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}
