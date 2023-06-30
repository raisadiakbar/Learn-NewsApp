package com.example.newsapp.data.remote.response

import com.google.gson.annotations.SerializedName

class NewsResponse(
    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("articles")
    val articles: List<ArticlesItem>,

    @SerializedName("status")
    val status: String
)

data class Source(

    @SerializedName("name")
    val name: String,

    @SerializedName("id")
    val id: Any
)

data class ArticlesItem(

    @SerializedName("publishedAt")
    val publishedAt: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("urlToImage")
    val urlToImage: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("source")
    val source: Source,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("content")
    val content: String
)