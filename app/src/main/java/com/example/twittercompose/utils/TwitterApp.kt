package com.example.twittercompose.utils

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.twittercompose.TwitterApplication
import com.example.twittercompose.ui.composables.bars.BottomBar
import com.example.twittercompose.ui.theme.TwitterTheme

@Composable
fun TwitterApp(
    baseApplication: TwitterApplication,
    bottomNavVM: BottomNavVM = hiltViewModel()
) {
    val navController = rememberNavController()

    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value
    ) {
        TwitterScaffold(
            baseApplication = baseApplication,
            bottomBar = {
                BottomBar(
                    navController = navController,
                    screens = bottomNavScreensList
                )
            },
            bottomNavVM = bottomNavVM,
            navController = navController,
        ) { paddingValues ->
            NavigationHost(
                navController = navController,
                bottomNavVM = bottomNavVM,
                baseApplication = baseApplication
            )
        }
    }
}