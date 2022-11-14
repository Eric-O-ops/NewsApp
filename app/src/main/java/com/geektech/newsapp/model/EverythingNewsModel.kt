package com.geektech.newsapp.model

import com.google.gson.annotations.SerializedName

data class EverythingNewsModel(

    @SerializedName("author")
    val author: String?,

    @SerializedName("title")
    val title: String,

    @SerializedName("content")
    val content: String,

    @SerializedName("urlToImage")
    val urlToImage: String
)
