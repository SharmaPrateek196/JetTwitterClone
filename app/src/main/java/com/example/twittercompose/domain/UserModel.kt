package com.example.twittercompose.domain

data class UserModel(
    val username: String,
    val userHandle: String,
    val followersCount: Int,
    val followingCount: Int
)

val me = UserModel(
    "Prateek Sharma",
    "@prateekSharma",
    997,
    23
)
