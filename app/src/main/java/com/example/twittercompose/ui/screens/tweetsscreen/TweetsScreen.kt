package com.example.twittercompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twittercompose.ui.composables.Tweet
import com.example.twittercompose.ui.composables.story.StoryPalette
import com.example.twittercompose.ui.screens.tweetsscreen.TweetsScreenVM
import com.example.twittercompose.ui.screens.tweetsscreen.TweetsScreenVM.StoriesListState
import com.example.twittercompose.ui.screens.tweetsscreen.TweetsScreenVM.TweetsListState
import com.example.twittercompose.utils.BottomNavVM
import com.example.twittercompose.utils.Screens

@Composable
fun TweetsScreen(
    tweetsScreenViewModel: TweetsScreenVM = hiltViewModel(),
    bottomNavViewModel: BottomNavVM
) {
    bottomNavViewModel.setCurrentScreen(Screens.BottomNavScreens.Home)

    val storiesMutableState: StoriesListState by tweetsScreenViewModel.storiesState.observeAsState(StoriesListState.Loading)
    val tweetsMutableState: TweetsListState by tweetsScreenViewModel.tweetState.observeAsState(TweetsListState.Loading)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StoriesList(storiesMutableState)
        Divider()
        TweetsList(tweetsMutableState)
    }
}

@Composable
fun StoriesList(
    state: StoriesListState
) {
    when(state) {
        is StoriesListState.Loading -> {
        }
        is StoriesListState.Success -> {
            StoryPalette(
                stories = state.data,
                modifier = Modifier
            )
        }
        is StoriesListState.Error -> {
        }
    }
}

@Composable
fun TweetsList(
    state: TweetsListState
) {
    when(state) {
        is TweetsListState.Loading -> {

        }
        is TweetsListState.Success -> {
            val list = state.data
            LazyColumn {
                items(list) { tweetModel ->
                    key(tweetModel.id) {
                        Tweet(
                            tweet = tweetModel,
                            modifier = Modifier
                        )
                    }
                    Divider()
                }
            }
        }
        is TweetsListState.Error -> {

        }
    }
}
