package com.geektech.newsapp.data.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geektech.newsapp.MAX_PAGE_SIZE
import com.geektech.newsapp.data.network.api.EverythingNewsApi
import com.geektech.newsapp.data.repositories.EverythingNewsRepository
import retrofit2.HttpException
import java.io.IOException

class EverythingNewsPagingSource(
    private val everythingNewsApi: EverythingNewsApi,
    private val query: String) : PagingSource<Int, EverythingNewsRepository>() {

    override fun getRefreshKey(state: PagingState<Int, EverythingNewsRepository>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EverythingNewsRepository> {

        val position:Int = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(MAX_PAGE_SIZE)
        return try {
            val response = everythingNewsApi.fetchEverythingNews(query, position)
            val nextPage = response.totalResults
            val nextPageNumber =
                if (nextPage < pageSize) position + 1
                else null
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}