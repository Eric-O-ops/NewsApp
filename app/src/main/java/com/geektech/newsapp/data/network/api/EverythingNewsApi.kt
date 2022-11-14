package com.geektech.newsapp.data.network.api

import com.geektech.newsapp.API_KEY
import com.geektech.newsapp.model.NewsResponse
import com.geektech.newsapp.model.EverythingNewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingNewsApi {

    @GET("/v2/everything")
    fun fetchEverythingNews(
        @Query("q") query: String = "apple",
        @Query("page") page:Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ):NewsResponse<EverythingNewsModel>
}