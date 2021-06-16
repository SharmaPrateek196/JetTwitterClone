package com.example.twittercompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.example.twittercompose.ui.theme.darkThemeBg
import com.example.twittercompose.ui.theme.white50
import com.example.twittercompose.utils.TwitterApp
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var baseApplication: TwitterApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = !baseApplication.isGlobalDarkTheme.value
            systemUiController.setSystemBarsColor(
                color = if(useDarkIcons) {
                    white50} else {
                        darkThemeBg
                    },
                darkIcons = useDarkIcons
            )

            ProvideWindowInsets {
                TwitterApp(
                    baseApplication = baseApplication
                )
            }
        }
    }
}