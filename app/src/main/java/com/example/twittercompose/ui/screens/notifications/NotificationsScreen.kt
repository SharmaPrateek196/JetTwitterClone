package com.example.twittercompose.ui.screens.notifications

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twittercompose.ui.screens.messages.MessagesScreenVM
import com.example.twittercompose.utils.BottomNavVM
import com.example.twittercompose.utils.Screens

@Composable
fun NotificationsScreen(
    notificationsScreenVM: NotificationsScreenVM = hiltViewModel(),
    bottomNavViewModel: BottomNavVM
) {
    bottomNavViewModel.setCurrentScreen(Screens.BottomNavScreens.Messages)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "This screen is under construction..."
        )
    }
}
