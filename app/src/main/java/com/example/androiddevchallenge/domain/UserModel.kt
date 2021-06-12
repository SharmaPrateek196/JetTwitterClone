package com.example.androiddevchallenge.domain

data class UserModel(
    val username: String,
    val userHandle: String,
    val followersCount: Int,
    val followingCount: Int
)
