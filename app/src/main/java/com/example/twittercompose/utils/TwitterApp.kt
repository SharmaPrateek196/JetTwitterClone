package com.example.twittercompose.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        ) {
            NavigationHost(
                navController = navController,
                bottomNavVM = bottomNavVM,
                modifier = Modifier.padding(bottom = 55.dp)
            )
        }
    }
}