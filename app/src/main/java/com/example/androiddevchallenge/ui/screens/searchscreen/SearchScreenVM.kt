package com.example.androiddevchallenge.ui.screens.searchscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.SearchRepo
import com.example.androiddevchallenge.domain.ForYouModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SearchScreenVM @Inject constructor(): ViewModel() {
    private val _forYouState = MutableLiveData<ForYouState>()
    val forYouState: LiveData<ForYouState> = _forYouState

    init {
        loadForYouData()
    }

    fun loadForYouData() {
        viewModelScope.launch {
            _forYouState.value = ForYouState.Loading
            delay(300)
            val result = SearchRepo.forYouData
            _forYouState.value = ForYouState.Success(result)
        }
    }

    sealed class ForYouState() {
        object Loading: ForYouState()
        class Success(val data: List<ForYouModel>): ForYouState()
        class Error(val message: String, val exception: Exception = Exception()): ForYouState()
    }
}