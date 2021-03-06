package com.example.twittercompose.ui.screens.tweetsscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twittercompose.data.StoriesRepo
import com.example.twittercompose.data.TweetsRepo
import com.example.twittercompose.domain.StoryModel
import com.example.twittercompose.domain.TweetModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeScreenVM @Inject constructor(): ViewModel() {

    private val _tweetState = MutableLiveData<TweetsListState>()
    val tweetState: LiveData<TweetsListState> = _tweetState

    private val _storiesState = MutableLiveData<StoriesListState>()
    val storiesState: LiveData<StoriesListState> = _storiesState

    init {
        loadStories()
        loadTweets()
    }

    fun loadTweets() {
        viewModelScope.launch {
            _tweetState.value = TweetsListState.Loading
            delay(300)
            val result = TweetsRepo.tweets
            _tweetState.value = TweetsListState.Success(result)
        }
    }

    fun loadStories() {
        viewModelScope.launch {
            _storiesState.value = StoriesListState.Loading
            delay(300)
            val result = StoriesRepo.stories
            _storiesState.value = StoriesListState.Success(result)
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