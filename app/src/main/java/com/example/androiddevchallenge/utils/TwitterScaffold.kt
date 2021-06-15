package com.example.androiddevchallenge.utils

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
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
    navController: NavHostController,
    content: @Composable ((PaddingValues) -> Unit)
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val currentScreen by bottomNavVM.currentScreen.observeAsState()

    val topBar: @Composable () -> Unit = {
        val hasSearchBar = (currentScreen == Screens.BottomNavScreens.Search || currentScreen == Screens.BottomNavScreens.Messages)
        val hasSettings = currentScreen != Screens.BottomNavScreens.Home
        val searchHint = if(currentScreen == Screens.BottomNavScreens.Search) { "Search Twitter" }
                        else { "Search for people and groups" }

        TwitterTopAppBar(
            onMenuClicked = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            },
            hasSearchBar = hasSearchBar,
            searchHint = searchHint,
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
                        navController.popBackStack(navController.graph.startDestinationId, false)
                    },
                    baseApplication
                )
            },
            bottomBar = bottomBar,
            content = content
        )
    }
}