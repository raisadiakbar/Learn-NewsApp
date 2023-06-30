package com.example.newsapp.data.di

import android.content.Context
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.data.local.room.NewsDb
import com.example.newsapp.data.remote.retrofit.ApiConfig

object Injection {

    fun provideRepository(context: Context): NewsRepository {

        val apiService = ApiConfig.getApiService()
        val database = NewsDb.getInstance(context)
        val dao = database.newsDao()
        return NewsRepository.getInstance(apiService, dao)
    }
}