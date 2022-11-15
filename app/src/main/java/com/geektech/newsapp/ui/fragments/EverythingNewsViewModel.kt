package com.geektech.newsapp.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geektech.newsapp.data.repositories.EverythingNewsRepository
import com.geektech.newsapp.model.EverythingNewsModel

class EverythingNewsViewModel(
    private val repository: EverythingNewsRepository
) : ViewModel() {

    fun fetchEverythingNewsRepository(): LiveData<PagingData<EverythingNewsModel>> {
        return repository.fetchEverythingNews().cachedIn(viewModelScope)
    }
}