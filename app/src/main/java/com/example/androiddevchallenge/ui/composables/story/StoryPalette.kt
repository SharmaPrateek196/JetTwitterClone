package com.example.androiddevchallenge.ui.composables.story

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.StoryModel

@Composable
fun StoryPalette(
    stories: List<StoryModel>,
    modifier: Modifier
) {
    Surface(
        modifier = modifier
            .wrapContentSize()
            .padding(start = 4.dp, top = 8.dp, end = 4.dp, bottom = 4.dp)
    ) {
        LazyRow {
            item {
                StoryAddThumbnail(
                    imageResource = R.drawable.my_pic,
                    modifier = Modifier,
                    imageViewSize = 44
                )
            }

            items(stories) { storyModel ->
                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )

                StoryUnseenThumbnail(
                    storyModel = storyModel,
                    imageViewSize = 45
                )
            }

        }
    }
}