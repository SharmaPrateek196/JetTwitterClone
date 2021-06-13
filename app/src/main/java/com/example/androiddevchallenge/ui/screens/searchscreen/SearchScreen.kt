package com.example.androiddevchallenge.ui.screens.searchscreen

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import com.example.androiddevchallenge.utils.BottomNavVM
import com.example.androiddevchallenge.utils.TwitterScaffold

@Composable
fun SearchScreen(
    searchScreenViewModel: SearchScreenVM = hiltViewModel(),
    bottomNavViewModel: BottomNavVM = hiltViewModel(),
    baseApplication: TwitterApplication
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value
    ) {
        TwitterScaffold(
            baseApplication = baseApplication,
            scaffoldState = scaffoldState,
            topBar = { /*TODO*/ }
        ) {





        }
    }


}