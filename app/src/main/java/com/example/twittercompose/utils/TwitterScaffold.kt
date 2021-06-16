package com.example.twittercompose.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.twittercompose.TwitterApplication
import com.example.twittercompose.domain.me
import com.example.twittercompose.ui.composables.bars.TwitterTopAppBar
import com.example.twittercompose.ui.composables.drawer.NavigationDrawer
import com.example.twittercompose.ui.theme.TwitterTheme
import com.google.accompanist.insets.systemBarsPadding
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

    val hasSearchBar1 = remember {mutableStateOf(false)}
    val hasSettings1 = remember {mutableStateOf(false)}
    val searchHint1 = remember { mutableStateOf("")}

    val topBar: @Composable (Screens?) -> Unit = { currentlyVisibleScreen ->
        hasSearchBar1.value = (currentlyVisibleScreen == Screens.BottomNavScreens.Search || currentlyVisibleScreen == Screens.BottomNavScreens.Messages)
        hasSettings1.value = currentlyVisibleScreen != Screens.BottomNavScreens.Home
        searchHint1.value = if(currentlyVisibleScreen == Screens.BottomNavScreens.Search) { "Search Twitter" }
                        else { "Search for people and groups" }

        TwitterTopAppBar(
            onMenuClicked = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            },
            hasSearchBar = hasSearchBar1.value,
            searchHint = searchHint1.value,
            hasSettings = hasSettings1.value
        )
    }

    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value,
    ) {
        Scaffold(
            topBar = { topBar(currentScreen) },
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
            modifier = Modifier.systemBarsPadding(),
            content = content
        )
    }
}