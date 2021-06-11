package com.example.androiddevchallenge.ui.screens.tweetsscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.StoriesRepo
import com.example.androiddevchallenge.data.TweetsRepo
import com.example.androiddevchallenge.domain.StoryModel
import com.example.androiddevchallenge.domain.TweetModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class TweetsScreenVM @Inject constructor(): ViewModel() {

    var tweetsState = mutableStateOf<TweetsListState>(TweetsListState.Loading)
        private set

    var storiesState = mutableStateOf<StoriesListState>(StoriesListState.Loading)
        private set

    fun loadTweets() {
        viewModelScope.launch {
            tweetsState.value = TweetsListState.Loading
            delay(300)
            val result = TweetsRepo.tweets
            tweetsState.value = TweetsListState.Success(result)
        }
    }

    fun loadStories() {
        viewModelScope.launch {
            storiesState.value = StoriesListState.Loading
            delay(300)
            val result = StoriesRepo.stories
            storiesState.value = StoriesListState.Success(result)
        }
    }

    sealed class TweetsListState() {
        object Loading: TweetsListState()
        class Success(val data: List<TweetModel>): TweetsListState()
        class Error(val message: String, val exception: Exception = Exception()): TweetsListState()
    }

    sealed class StoriesListState() {
        object Loading: StoriesListState()
        class Success(val data: List<StoryModel>): StoriesListState()
        class Error(val message: String, val exception: Exception = Exception()): StoriesListState()
    }
}