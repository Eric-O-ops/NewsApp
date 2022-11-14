package com.geektech.newsapp.data.repositories

import androidx.lifecycle.MutableLiveData
import com.geektech.newsapp.data.network.api.EverythingNewsApi
import com.geektech.newsapp.model.NewsResponse
import com.geektech.newsapp.model.EverythingNewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EverythingNewsRepository(
    private val everythingNewsApi: EverythingNewsApi
) {
    private val data: MutableLiveData<NewsResponse<EverythingNewsModel>> = MutableLiveData()

    fun fetchEverythingNews(): MutableLiveData<NewsResponse<EverythingNewsModel>> {
        everythingNewsApi.fetchEverythingNews().enqueue(
            object : Callback<NewsResponse<EverythingNewsModel>> {
                override fun onResponse(
                    call: Call<NewsResponse<EverythingNewsModel>>,
                    response: Response<NewsResponse<EverythingNewsModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<NewsResponse<EverythingNewsModel>>,
                    t: Throwable
                ) {

                }
            })
        return data
    }
}