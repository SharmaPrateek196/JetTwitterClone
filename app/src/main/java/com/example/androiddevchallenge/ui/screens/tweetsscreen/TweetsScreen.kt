package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.ui.composables.Tweet
import com.example.androiddevchallenge.ui.composables.story.StoryPalette
import com.example.androiddevchallenge.ui.composables.topbar.TweetsScreenAppBar
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM.StoriesListState
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM.TweetsListState
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import com.example.androiddevchallenge.utils.BottomNavVM
import com.example.androiddevchallenge.utils.TwitterScaffold
import kotlinx.coroutines.launch

@Composable
fun TweetsScreen(
    tweetsScreenViewModel: TweetsScreenVM = hiltViewModel(),
    bottomNavViewModel: BottomNavVM = hiltViewModel() ,
    baseApplication: TwitterApplication
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    tweetsScreenViewModel.loadStories()
    tweetsScreenViewModel.loadTweets()

    val storiesMutableState: StoriesListState by tweetsScreenViewModel.storiesState.observeAsState(StoriesListState.Loading)
    val tweetsMutableState: TweetsListState by tweetsScreenViewModel.tweetState.observeAsState(TweetsListState.Loading)

    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value,
    ) {
        TwitterScaffold(
            baseApplication = baseApplication,
            scaffoldState = scaffoldState,
            topBar = { TweetsScreenAppBar(
                onMenuClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) }
        ){

            Column {
                StoriesList(storiesMutableState)

                Divider()

                TweetsList(tweetsMutableState)
            }
        }
    }
}

@Composable
fun StoriesList(
    state: TweetsScreenVM.StoriesListState
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
