package com.example.androiddevchallenge

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TwitterApplication : Application() {
    // Should be saved in SharedPreferences or Local DB in a production app
    var isGlobalDarkTheme = mutableStateOf(false)

    fun onThemeChanged() {
        isGlobalDarkTheme.value = !isGlobalDarkTheme.value
    }
}