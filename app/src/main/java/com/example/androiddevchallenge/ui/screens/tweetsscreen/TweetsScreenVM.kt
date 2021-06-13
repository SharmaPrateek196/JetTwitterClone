package com.example.androiddevchallenge.ui.screens.tweetsscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _tweetState2 = MutableLiveData<TweetsListState>()
    val tweetState2: LiveData<TweetsListState> = _tweetState2

    private val _storiesState2 = MutableLiveData<StoriesListState>()
    val storiesState2: LiveData<StoriesListState> = _storiesState2

    fun loadTweets() {
        viewModelScope.launch {
            _tweetState2.value = TweetsListState.Loading
            delay(300)
            val result = TweetsRepo.tweets
            _tweetState2.value = TweetsListState.Success(result)
        }
    }

    fun loadStories() {
        viewModelScope.launch {
            _storiesState2.value = StoriesListState.Loading
            delay(300)
            val result = StoriesRepo.stories
            _storiesState2.value = StoriesListState.Success(result)
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