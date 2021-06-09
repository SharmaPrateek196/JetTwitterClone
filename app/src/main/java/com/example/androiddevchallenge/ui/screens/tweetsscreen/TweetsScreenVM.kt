package com.example.androiddevchallenge.ui.screens.tweetsscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.domain.TweetModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

@HiltViewModel
class TweetsScreenVM: ViewModel() {

    var tweetsState = mutableStateOf(TweetsScreenState.Loading)
        private set

    fun loadTweets() {
        viewModelScope.launch {

        }
    }










    sealed class TweetsScreenState() {
        object Loading: TweetsScreenState()
        class Success(data: List<TweetModel>)
        class Error(message: String, exception: Exception = Exception())
    }
}