package com.geektech.newsapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.geektech.newsapp.data.network.api.EverythingNewsApi
import com.geektech.newsapp.data.repositories.pagingsources.EverythingNewsPagingSource
import com.geektech.newsapp.model.EverythingNewsModel

class EverythingNewsRepository(
    private val everythingNewsApi: EverythingNewsApi
) {
    fun fetchEverythingNews(): LiveData<PagingData<EverythingNewsModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                EverythingNewsPagingSource(everythingNewsApi)
            }, initialKey = 1
        ).liveData
    }
}