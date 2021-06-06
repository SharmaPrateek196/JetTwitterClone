package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.androiddevchallenge.ui.composables.story.StoryPalette
import com.example.androiddevchallenge.ui.composables.topbar.MainTopAppBar

@Composable
fun TweetsScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { MainTopAppBar() }
    ) {
        Column {
            StoryPalette(modifier = Modifier)
            Divider()

        }
    }
}