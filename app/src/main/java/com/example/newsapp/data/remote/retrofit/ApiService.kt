package com.example.newsapp.data.remote.retrofit

import com.example.newsapp.data.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines?country=us")
    suspend fun getNews(
        @Query("apiKey") apikey: String
    ): NewsResponse
}