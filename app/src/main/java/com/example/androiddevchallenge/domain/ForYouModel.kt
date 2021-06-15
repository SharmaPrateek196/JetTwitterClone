package com.example.androiddevchallenge.domain

data class ForYouModel(
    val id: Int,
    val title: String,
    val heading: String,
    val additionalComment: String
)

data class TextOnImageModel(
    val id: Int = 0,
    val headingText: String,
    val subHeadingText: String,
    val imageUrl: String
)
