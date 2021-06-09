package com.example.androiddevchallenge.domain

data class TweetModel (
    val tweeterName: String,
    val handleName: String,
    val timeTweeted: String,
    val isVerified: Boolean = false,
    val userImageResource: Int,
    val hasImage: Boolean = false,
    val imageResource: Int,
    val hasVideo: Boolean,
    val videoUrl: String,
    val totalComments: String,
    val totalRetweets: String,
    val totalLikes: String
)