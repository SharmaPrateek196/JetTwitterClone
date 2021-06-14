package com.example.androiddevchallenge.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.domain.me
import com.example.androiddevchallenge.ui.composables.bars.TwitterTopAppBar
import com.example.androiddevchallenge.ui.composables.drawer.NavigationDrawer
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import kotlinx.coroutines.launch


@Composable
fun TwitterScaffold(
    baseApplication: TwitterApplication,
    bottomBar: @Composable () -> Unit,
    content: @Composable ((PaddingValues) -> Unit)
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val hasSearchBar = remember { mutableStateOf(true) }

    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value,
    ) {
        Scaffold(
            topBar = {
                TwitterTopAppBar(
                    onMenuClicked = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    },
                    hasSearchBar = hasSearchBar.value
                )
            },
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