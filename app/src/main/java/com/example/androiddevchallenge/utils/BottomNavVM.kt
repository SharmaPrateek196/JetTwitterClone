package com.example.androiddevchallenge.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomNavVM @Inject constructor(): ViewModel() {
    private val _currentScreen = MutableLiveData<Screens>()
    val currentScreen: LiveData<Screens> = _currentScreen

    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen

        Log.d("TAG", "setCurrentScreen: "+currentScreen.value.toString())
    }
}