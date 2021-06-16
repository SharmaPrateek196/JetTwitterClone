package com.example.twittercompose.domain

data class TweetModel (
    val id: Int,
    val tweeterName: String,
    val handleName: String,
    val timeTweeted: String,
    val isVerified: Boolean = false,
    val tweetText: String,
    val userImageResource: String,
    val hasImage: Boolean = false,
    val imageResource: String,
    val hasVideo: Boolean,
    val videoUrl: String,
    val totalComments: Int,
    val totalRetweets: Int,
    val totalLikes: Int
)