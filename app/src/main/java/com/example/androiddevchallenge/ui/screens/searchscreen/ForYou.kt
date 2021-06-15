package com.example.androiddevchallenge.ui.screens.searchscreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.ForYouModel

@Composable
fun ForYouLayout(
    dataState: SearchScreenVM.ForYouState
) {
    when(dataState) {
        is SearchScreenVM.ForYouState.Loading -> {

        }
        is SearchScreenVM.ForYouState.Success -> {
            val forYouListData = dataState.data
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            LazyColumn {
                items(forYouListData) { forYouModel ->
                    key(forYouModel.id) {
                        ForYouItem(forYouModel)
                    }
                }
            }
        }
        is SearchScreenVM.ForYouState.Error -> {

        }
    }
}

@Composable
fun ForYouItem(
    model: ForYouModel
) {
    Surface() {
        Text(text = "this is a for you item")
    }
}