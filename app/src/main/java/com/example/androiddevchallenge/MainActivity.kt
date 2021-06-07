package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.TweetsScreen
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "tweets_Screen"
                ) {
                    composable("tweets_Screen") {
                        TweetsScreen(navController = navController)
                    }
                }

            }
        }
    }
}