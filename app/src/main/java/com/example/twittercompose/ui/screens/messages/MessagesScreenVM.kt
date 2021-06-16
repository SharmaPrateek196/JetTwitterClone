package com.example.twittercompose.ui.screens.messages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twittercompose.data.MessagesRepo
import com.example.twittercompose.domain.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MessagesScreenVM @Inject constructor(): ViewModel() {

    private val _messagesState = MutableLiveData<MessagesListState>()
    val messagesState: LiveData<MessagesListState> = _messagesState

    init {
        loadMessages()
    }

    fun loadMessages() {
        viewModelScope.launch {
            _messagesState.value = MessagesListState.Loading
            delay(300)
            val result = MessagesRepo.messages
            _messagesState.value = MessagesListState.Success(result)
        }
    }

    sealed class MessagesListState() {
        object Loading: MessagesListState()
        class Success(val data: List<MessageModel>): MessagesListState()
        class Error(val message: String, val exception: Exception = Exception()): MessagesListState()
    }
}