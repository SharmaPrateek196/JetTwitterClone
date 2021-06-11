package com.example.androiddevchallenge.ui.composables.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
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
            ).width(550.dp)
                .height(200.dp),
            contentScale = ContentScale.FillBounds
        )
}