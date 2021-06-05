package com.example.androiddevchallenge.ui.composables.story

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.circularShape
import com.example.androiddevchallenge.ui.theme.twitterBlue

@Composable
fun StoryUnseenThumbnail(
    @DrawableRes imageResource: Int,
    modifier: Modifier,
    imageViewSize: Int
) {
    Surface {
        Image(
            painter = painterResource(id = imageResource),
            null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .size(imageViewSize.dp)
                .clip(
                    shape = circularShape
                )
                .border(
                    border = BorderStroke(2.dp, twitterBlue),
                    shape = circularShape
                )
                .padding(3.dp)
        )
    }
}

@Composable
fun StorySeenThumbnail(
    @DrawableRes imageResource: Int,
    modifier: Modifier,
    imageViewSize: Int
) {
    Surface {
        Image(
            painter = painterResource(id = imageResource),
            null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .size(imageViewSize.dp)
                .clip(
                    shape = circularShape
                )
        )
    }
}

@Composable
fun StoryAddThumbnail(
    @DrawableRes imageResource: Int,
    modifier: Modifier,
    imageViewSize: Int
) {
    Surface {
        SelectionContainer {
            Image(
                painter = painterResource(id = imageResource),
                null,
                contentScale = ContentScale.FillBounds,
                modifier = modifier
                    .size(imageViewSize.dp)
                    .clip(
                        shape = circularShape
                    )
            )
            AddImage(
                modifier
            )
        }
    }
}

@Composable
fun AddImage(
    modifier: Modifier
) {
    Surface(
        shape = circularShape
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            modifier = modifier
                .size(8.dp)
                .padding(1.dp)
        )
    }
}

@Preview
@Composable
fun StoryUnseenThumbnailPreview(){
    StoryUnseenThumbnail(
        R.drawable.twitter_logo,
        Modifier,
        35
    )
}

@Preview
@Composable
fun StoryseenThumbnailPreview(){
    StorySeenThumbnail(
        R.drawable.twitter_logo,
        Modifier,
        35
    )
}

@Preview
@Composable
fun StoryAddPreview(){
    StoryAddThumbnail(
        R.drawable.twitter_logo,
        Modifier,
        35
    )
}

@Preview
@Composable
fun AddImagePreview(){
    AddImage(
        Modifier
    )
}