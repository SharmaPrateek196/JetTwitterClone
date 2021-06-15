package com.example.androiddevchallenge.utils

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.domain.me
import com.example.androiddevchallenge.ui.composables.bars.TwitterTopAppBar
import com.example.androiddevchallenge.ui.composables.drawer.NavigationDrawer
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import kotlinx.coroutines.launch


@Composable
fun TwitterScaffold(
    baseApplication: TwitterApplication,
    bottomBar: @Composable () -> Unit,
    bottomNavVM: BottomNavVM,
    content: @Composable ((PaddingValues) -> Unit)
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    //val hasSearchBar = remember { mutableStateOf(true) }
    val currentScreen by bottomNavVM.currentScreen.observeAsState()

    val topBar: @Composable () -> Unit = {
        val hasSearchBar = currentScreen == Screens.BottomNavScreens.Search
        val hasSettings = currentScreen != Screens.BottomNavScreens.Home
        TwitterTopAppBar(
            onMenuClicked = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            },
            hasSearchBar = hasSearchBar,
            hasSettings = hasSettings
        )
    }

    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value,
    ) {
        Scaffold(
            topBar = { topBar() },
            drawerBackgroundColor = MaterialTheme.colors.primary,
            scaffoldState = scaffoldState,
            drawerContent = {
                NavigationDrawer(
                    currentUser = me,
                    onThemeChanged = {
                        baseApplication.onThemeChanged()
                    },
                    baseApplication
                )
            },
            bottomBar = bottomBar,
            content = content
        )
    }
}