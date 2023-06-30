package com.example.newsapp.ui.detailnews

import androidx.lifecycle.ViewModel
import com.example.newsapp.data.NewsRepository

class DetailNewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getHeadlineNews() = newsRepository.getHeadlineNews()
}