package com.geektech.newsapp.data.repositories.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geektech.newsapp.MAX_PAGE_SIZE
import com.geektech.newsapp.data.network.api.EverythingNewsApi
import com.geektech.newsapp.model.EverythingNewsModel
import retrofit2.HttpException
import java.io.IOException

class EverythingNewsPagingSource(
    private val everythingNewsApi: EverythingNewsApi,
) : PagingSource<Int, EverythingNewsModel>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EverythingNewsModel> {

        val position: Int = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(MAX_PAGE_SIZE)
        return try {
            val response = everythingNewsApi.fetchEverythingNews("apple", position)
            val nextPage = response.totalResults
            val nextPageNumber =
                if (nextPage > pageSize) position + 1
                else null
            LoadResult.Page(
                data = response.articles,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, EverythingNewsModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}