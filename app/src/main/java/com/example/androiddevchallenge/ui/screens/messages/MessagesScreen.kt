package com.example.androiddevchallenge.ui.screens.messages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androiddevchallenge.ui.composables.message.Message
import com.example.androiddevchallenge.utils.BottomNavVM
import com.example.androiddevchallenge.utils.Screens

@Composable
fun MessagesScreen(
    messagesScreenVM: MessagesScreenVM = hiltViewModel(),
    bottomNavViewModel: BottomNavVM
) {
    bottomNavViewModel.setCurrentScreen(Screens.BottomNavScreens.Messages)

    val messagesMutableState: MessagesScreenVM.MessagesListState by messagesScreenVM.messagesState.observeAsState(
        MessagesScreenVM.MessagesListState.Loading)

    Column() {
        Divider(thickness = 1.dp)
        MessagesList(messagesMutableState)
    }
}

@Composable
fun MessagesList(
    state: MessagesScreenVM.MessagesListState
) {
    when(state) {
        is MessagesScreenVM.MessagesListState.Loading -> {

        }
        is MessagesScreenVM.MessagesListState.Success -> {
            val list = state.data
            LazyColumn {
                items(list) { messageModel ->
                    key(messageModel.id) {
                        Message(
                            message = messageModel,
                            modifier = Modifier
                        )
                    }
                    Divider(thickness = 0.5.dp)
                }
            }
        }
        is MessagesScreenVM.MessagesListState.Error -> {

        }
    }
}