package com.example.androiddevchallenge.ui.composables.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.circularShape
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CircularImage(
    imageResource: String,
    modifier: Modifier,
    imageViewSize: Int
) {
    CoilImage(
        data = imageResource,
        null,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            .size(imageViewSize.dp)
            .clip(
                shape = circularShape
            )
    )
}