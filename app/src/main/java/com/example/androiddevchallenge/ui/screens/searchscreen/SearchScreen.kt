package com.example.androiddevchallenge.ui.screens.searchscreen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androiddevchallenge.utils.BottomNavVM
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    searchScreenViewModel: SearchScreenVM = hiltViewModel(),
    bottomNavViewModel: BottomNavVM = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

//    TwitterTheme(
//        darkTheme = baseApplication.isGlobalDarkTheme.value,
//    ) {
//        Scaffold(
//            topBar = {
//                MainTopAppBar(
//                    onMenuClicked = {
//                        scope.launch {
//                            scaffoldState.drawerState.open()
//                        }
//                    }
//                )
//            },
//            drawerBackgroundColor = MaterialTheme.colors.primary,
//            scaffoldState = scaffoldState,
//            drawerContent = {
//                NavigationDrawer(
//                    currentUser = me,
//                    onThemeChanged = {
//                        baseApplication.onThemeChanged()
//                    },
//                    baseApplication
//                )
//            }
//        ) {
//
//
//
//        }
//    }

}