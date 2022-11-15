package com.geektech.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentEverythingNewsBinding
import com.geektech.newsapp.ui.adapters.EverythingNewsAdapter
import kotlinx.coroutines.launch
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
            lifecycleScope.launch {
                allNewsAdapter.submitData(it)
                Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            }
        }
    }
}