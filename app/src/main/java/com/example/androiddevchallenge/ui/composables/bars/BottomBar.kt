package com.example.androiddevchallenge.ui.composables.bars

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androiddevchallenge.utils.Screens

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    screens: List<Screens.BottomNavScreens>,
    navController: NavController
) {
    BottomNavigation(modifier = modifier) {
        val navBackStackEntry: State<NavBackStackEntry?> = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.arguments?.getString(KEY_ROUTE)
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = screen.iconResource),
                        contentDescription = ""
                    )
                },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.popBackStack(navController.graph.startDestinationId, false)
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}