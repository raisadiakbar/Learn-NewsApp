package com.example.newsapp.data

sealed class Result<out R> private constructor() {

    data class Success<out T>(val data: T) : com.example.newsapp.data.Result<T>()
    data class Error(val error: String) : com.example.newsapp.data.Result<Nothing>()
    object Loading : com.example.newsapp.data.Result<Nothing>()

}
