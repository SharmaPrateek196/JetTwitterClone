package com.example.androiddevchallenge.ui.composables.bars

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androiddevchallenge.utils.Screens
import com.example.androiddevchallenge.ui.theme.grey

@Composable
fun BottomBar(
    screens: List<Screens.BottomNavScreens>,
    navController: NavController
) {
    BottomNavigation {
        val navBackStackEntry: State<NavBackStackEntry?> = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route
        screens.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.align(Alignment.CenterVertically),
                icon = {
                    Icon(
                        painterResource(id = screen.iconResource),
                        contentDescription = "",
                        tint = grey
                    )
                },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.popBackStack(navController.graph.startDestinationId, false)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}