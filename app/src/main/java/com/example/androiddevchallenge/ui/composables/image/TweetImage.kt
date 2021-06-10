package com.example.androiddevchallenge.ui.composables.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.rectangulerShapeRounderCorner
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun TweetImage(
    imageResource: String,
    modifier: Modifier
) {
        CoilImage(
            data = imageResource,
            contentDescription = null,
            modifier = modifier.clip(
                rectangulerShapeRounderCorner
            ),
            contentScale = ContentScale.FillBounds
        )
}