package com.geektech.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentEverythingNewsBinding
import com.geektech.newsapp.ui.adapters.EverythingNewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class EverythingNewsFragment : Fragment(R.layout.fragment_everything_news) {

    private val binding by viewBinding(FragmentEverythingNewsBinding::bind)
    private val viewModel by viewModel<EverythingNewsViewModel>()
    private val allNewsAdapter = EverythingNewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = allNewsAdapter
        }
    }

    private fun setupObserve() {

        viewModel.fetchEverythingNewsRepository().observe(viewLifecycleOwner) {
            allNewsAdapter.submitList(it.articles)
        }
    }
}