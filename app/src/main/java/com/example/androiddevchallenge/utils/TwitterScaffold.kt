package com.example.androiddevchallenge.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.domain.me
import com.example.androiddevchallenge.ui.composables.drawer.NavigationDrawer
import com.example.androiddevchallenge.ui.theme.TwitterTheme


@Composable
fun TwitterScaffold(
    baseApplication: TwitterApplication,
    scaffoldState: ScaffoldState,
    topBar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    content: @Composable ((PaddingValues) -> Unit)
) {
    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value,
    ) {
        Scaffold(
            topBar = topBar,
            drawerBackgroundColor = MaterialTheme.colors.primary,
            scaffoldState = scaffoldState,
            drawerContent = {
                NavigationDrawer(
                    currentUser = me,
                    onThemeChanged = {
                        baseApplication.onThemeChanged()
                    },
                    baseApplication
                )
            },
            bottomBar = bottomBar,
            content = content
        )
    }
}