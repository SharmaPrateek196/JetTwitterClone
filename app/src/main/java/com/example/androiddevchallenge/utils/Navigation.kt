package com.example.androiddevchallenge.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.ui.screens.TweetsScreen
import com.example.androiddevchallenge.ui.screens.messages.MessagesScreen
import com.example.androiddevchallenge.ui.screens.searchscreen.SearchScreen
import com.example.androiddevchallenge.utils.Screens.BottomNavScreens

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