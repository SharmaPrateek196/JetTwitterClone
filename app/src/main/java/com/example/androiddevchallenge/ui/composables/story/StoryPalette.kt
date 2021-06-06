package com.example.androiddevchallenge.ui.composables.story

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun StoryPalette(
    //list of data to be come,
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
            for (i in 1..12) {
                item {
                    Spacer(
                        modifier = Modifier
                            .width(8.dp)
                    )

                    StoryUnseenThumbnail(
                        imageResource = R.drawable.twitter_logo,
                        "This text should be truncated",
                        imageViewSize = 45
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun StoryPalettePreview() {
    StoryPalette(modifier = Modifier)
}