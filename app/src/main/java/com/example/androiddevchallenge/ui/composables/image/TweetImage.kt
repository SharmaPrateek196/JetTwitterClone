package com.example.androiddevchallenge.ui.composables.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.androiddevchallenge.ui.theme.rectangulerShapeRounderCorner
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun TweetImage(
    imageResource: String,
    modifier: Modifier
) {
        Image(
            painter = rememberCoilPainter(imageResource),
            contentDescription = null,
            modifier = modifier.clip(
                rectangulerShapeRounderCorner
            ),
            contentScale = ContentScale.FillBounds
        )
}