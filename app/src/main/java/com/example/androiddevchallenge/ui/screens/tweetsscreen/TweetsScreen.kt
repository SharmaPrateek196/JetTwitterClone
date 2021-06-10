package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.ui.composables.Tweet
import com.example.androiddevchallenge.ui.composables.story.StoryPalette
import com.example.androiddevchallenge.ui.composables.topbar.MainTopAppBar
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM.TweetsScreenState

@Composable
fun TweetsScreen(
    navController: NavController,
    viewModel: TweetsScreenVM = hiltViewModel()
) {
    viewModel.loadTweets()
    val tweetsMutableState = remember { viewModel.tweetsState }

    Scaffold(
        topBar = { MainTopAppBar() },
        backgroundColor = MaterialTheme.colors.background
    ) {

        Column {
            StoryPalette(modifier = Modifier)

            Divider(
                color = MaterialTheme.colors.onPrimary
            )

            TweetsList(tweetsMutableState.value)
        }
    }
}

@Composable
fun TweetsList(state: TweetsScreenState) {
    when(state) {
        is TweetsScreenState.Loading -> {

        }
        is TweetsScreenState.Success -> {
            val list = state.data
            LazyColumn {
                items(list) { tweetModel ->
                    Tweet(
                        tweet = tweetModel,
                        modifier = Modifier
                    )
                    Divider()
                }
            }
        }
        is TweetsScreenState.Error -> {

        }
    }
}
