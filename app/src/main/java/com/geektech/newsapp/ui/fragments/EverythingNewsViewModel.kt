package com.geektech.newsapp.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.newsapp.data.repositories.EverythingNewsRepository
import com.geektech.newsapp.model.NewsResponse
import com.geektech.newsapp.model.EverythingNewsModel

class EverythingNewsViewModel (
    private val repository: EverythingNewsRepository
) : ViewModel() {


    fun fetchEverythingNewsRepository(): MutableLiveData<NewsResponse<EverythingNewsModel>> {
        return repository.fetchEverythingNews()
    }
}