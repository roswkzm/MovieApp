package com.example.movieapp.features.feed.presentation.input

interface IFeedViewModelInputs {
    fun openDetail(movieName : String)
    fun openInfoDialog()
    fun refreshFeed()
}