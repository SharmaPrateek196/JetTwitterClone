package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.domain.me
import com.example.androiddevchallenge.ui.composables.Tweet
import com.example.androiddevchallenge.ui.composables.drawer.NavigationDrawer
import com.example.androiddevchallenge.ui.composables.story.StoryPalette
import com.example.androiddevchallenge.ui.composables.topbar.MainTopAppBar
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM.StoriesListState
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM.TweetsListState
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun TweetsScreen(
    navController: NavController,
    viewModel: TweetsScreenVM = hiltViewModel(),
    baseApplication: TwitterApplication
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    viewModel.loadStories()
    val storiesMutableState = remember { viewModel.storiesState }
    viewModel.loadTweets()
    val tweetsMutableState = remember { viewModel.tweetsState }

    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value
    ) {
        Scaffold(
            topBar = { MainTopAppBar(
                onMenuClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) },
            backgroundColor = MaterialTheme.colors.background,
            scaffoldState = scaffoldState,
            drawerContent = { NavigationDrawer(
                currentUser = me,
                onThemeChanged = {
                    baseApplication.onThemeChanged()
                },
                baseApplication
            ) }
        ) {

            Column {
                StoriesList(storiesMutableState.value)

                Divider()

                TweetsList(tweetsMutableState.value)
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
