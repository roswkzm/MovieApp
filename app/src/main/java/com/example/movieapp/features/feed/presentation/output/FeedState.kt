package com.example.movieapp.features.feed.presentation.output

sealed class FeedState {
    object Loading : FeedState()

    class Main(
        val movielist : List<MovieFeedItemEntity>
    ) : FeedState()

    class Failed(
        val reason : String
    ) : FeedState()
}