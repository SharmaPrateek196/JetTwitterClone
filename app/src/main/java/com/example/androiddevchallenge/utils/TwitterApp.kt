package com.example.androiddevchallenge.utils

import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.ui.composables.bars.BottomBar
import com.example.androiddevchallenge.ui.composables.bars.TwitterTopAppBar
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import kotlinx.coroutines.launch

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
            bottomNavVM = bottomNavVM
        ) { paddingValues ->
            NavigationHost(
                navController = navController,
                bottomNavVM = bottomNavVM,
                baseApplication = baseApplication
            )
        }
    }
}