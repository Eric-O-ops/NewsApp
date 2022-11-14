package com.geektech.newsapp.model

import com.google.gson.annotations.SerializedName

data class NewsResponse<T>(

    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("articles")
    val articles: List<T>
)
