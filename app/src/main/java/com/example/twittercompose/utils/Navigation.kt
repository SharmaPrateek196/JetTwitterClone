package com.example.twittercompose.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.twittercompose.TwitterApplication
import com.example.twittercompose.ui.screens.TweetsScreen
import com.example.twittercompose.ui.screens.messages.MessagesScreen
import com.example.twittercompose.ui.screens.searchscreen.SearchScreen
import com.example.twittercompose.utils.Screens.BottomNavScreens

@Composable
fun NavigationHost(
    navController: NavController,
    bottomNavVM: BottomNavVM,
    baseApplication: TwitterApplication
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = BottomNavScreens.Home.route
    ) {
        composable(BottomNavScreens.Home.route) {
            TweetsScreen(bottomNavViewModel = bottomNavVM)
        }
        composable(BottomNavScreens.Search.route) {
            SearchScreen(bottomNavViewModel = bottomNavVM)
        }
        composable(BottomNavScreens.Notifications.route) {

        }
        composable(BottomNavScreens.Messages.route) {
            MessagesScreen(bottomNavViewModel = bottomNavVM)
        }

    }
}

enum class SearchCategory(val titleText: String) {
    ForYou("For You"),
    Covid("COVID-19"),
    Trending("Trending"),
    News("News"),
    Sports("Sports"),
    Entertainment("Entertainment")
}