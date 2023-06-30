package com.example.newsapp.ui.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.data.local.entity.NewsEntity
import kotlinx.coroutines.launch

class BookmarkViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    fun getBookmark() = newsRepository.getBookmarked()

    fun delete(news: NewsEntity) {
        viewModelScope.launch {
            newsRepository.setBookmark(news, false)
        }
    }
}