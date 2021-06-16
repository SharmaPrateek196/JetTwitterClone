package com.example.twittercompose.domain

data class MessageModel (
    val id: Int,
    val username: String,
    val userHandle: String,
    val isVerified: Boolean = true,
    val messageTime: String,
    val messageText: String,
    val userProfileUrl: String
)