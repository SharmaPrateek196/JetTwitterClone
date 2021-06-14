package com.example.androiddevchallenge.utils

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

sealed class Screens(val hasIcon: Boolean, @DrawableRes val iconResource: Int, val title: String, val route: String) {

    sealed class BottomNavScreens(iconResource: Int, route: String)
        :Screens(false, iconResource, "", route) {
        object Home : BottomNavScreens( R.drawable.ic_home_unselected, "home")
        object Search : BottomNavScreens( R.drawable.ic_search_unselected, "search")
        object Notifications : BottomNavScreens( R.drawable.ic_notification_unselected, "notifications")
        object Messages : BottomNavScreens( R.drawable.ic_message_unselected, "messages")
    }

    sealed class DrawerOptions(hasIcon: Boolean, iconResource: Int, title: String, route: String)
        :Screens(hasIcon, iconResource, title, route) {
        object Profile : DrawerOptions(true, R.drawable.ic_person, "Profile", "profile")
        object Lists : DrawerOptions(true, R.drawable.ic_lists, "Lists", "lists")
        object Topics : DrawerOptions( true, R.drawable.ic_topics, "Topics", "topics")
        object Bookmarks : DrawerOptions( true, R.drawable.ic_bookmark, "Bookmarks", "bookmarks")
        object Moments : DrawerOptions( true, R.drawable.ic_moments, "Moments", "moments")
        object SettingsAndPrivacy : DrawerOptions( false, 0,"Settings And Privacy", "settings_and_privacy")
        object HelpCentre : DrawerOptions( false, 0, "Help Centre", "help_centre")
    }
}

val bottomNavScreensList = listOf(
    Screens.BottomNavScreens.Home,
    Screens.BottomNavScreens.Search,
    Screens.BottomNavScreens.Notifications,
    Screens.BottomNavScreens.Messages
)