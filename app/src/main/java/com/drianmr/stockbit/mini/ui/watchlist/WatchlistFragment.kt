package com.drianmr.stockbit.mini.ui.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.drianmr.stockbit.mini.R
import com.drianmr.stockbit.mini.databinding.FragmentWatchlistBinding
import com.drianmr.stockbit.mini.ext.verticalLayoutManager
import com.drianmr.stockbit.mini.ui.base.BaseUiFragment
import dagger.hilt.android.AndroidEntryPoint
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class WatchlistFragment : BaseUiFragment() {

    @Inject
    lateinit var watchlistAdapter: WatchlistAdapter

    private var _binding: FragmentWatchlistBinding? = null
    private val binding get() = _binding!!

    private val watchlistViewModel: WatchlistViewModel by viewModels()

    override fun onCreateViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
        observeData()
    }

    private fun setup() {
        setupSwipeRefreshLayout()
        setupRecyclerView()
    }

    private fun setupSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = true
            watchlistAdapter.refresh()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewWatchlist.apply {
            layoutManager = verticalLayoutManager()
            adapter = watchlistAdapter
        }

        watchlistAdapter.addLoadStateListener { loadState ->
            if (loadState.source.refresh is LoadState.Loading) {
                showListSkeleton()
            } else {
                hideListSkeleton()
            }
        }
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            watchlistViewModel.listCrypto.collect { pagingData ->
                watchlistAdapter.submitData(pagingData)
            }
        }
    }

    private fun showListSkeleton() {
        binding.recyclerViewWatchlist.loadSkeleton(R.layout.item_watchlist) {
            shimmer(false)
            color(R.color.divider)
            itemCount(15)
        }
    }

    private fun hideListSkeleton() {
        binding.recyclerViewWatchlist.hideSkeleton()
    }
}
