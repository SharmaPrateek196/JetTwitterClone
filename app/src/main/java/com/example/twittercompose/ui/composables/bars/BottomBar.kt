package com.example.twittercompose.ui.composables.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.twittercompose.R
import com.example.twittercompose.utils.Screens
import com.example.twittercompose.ui.theme.grey
import com.example.twittercompose.ui.theme.twitterBlue

@Composable
fun BottomBar(
    screens: List<Screens.BottomNavScreens>,
    navController: NavController
) {
    Column {
        Divider(thickness = 0.5.dp)
        BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            screens.forEach { screen ->
                BottomNavigationItem(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .background(MaterialTheme.colors.primary),
                    icon = {
                        BottomNavIcon(currentRoute, screen.route, screen.iconResource, screen.iconResourceSelected)
                    },
                    selected = currentRoute == screen.route,
                    onClick = {
                        if(currentRoute != screen.route) {
                            navController.navigate(screen.route) {
                                navController.popBackStack(navController.graph.startDestinationId, false)
                                launchSingleTop = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun BottomNavIcon(currentRoute: String?, screenRoute: String, iconResourceUnselected: Int, iconResourceSelected: Int) {
    var tint = grey
    var iconResource = iconResourceUnselected

    if(currentRoute == screenRoute) {
        iconResource = iconResourceSelected
        tint = twitterBlue
    } else {
        iconResource = iconResourceUnselected
        tint = grey
    }

    Icon(
        painterResource(id = iconResource),
        contentDescription = "",
        tint = tint
    )
}
