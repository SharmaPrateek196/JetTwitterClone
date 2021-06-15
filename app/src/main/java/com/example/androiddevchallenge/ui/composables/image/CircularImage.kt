package com.example.androiddevchallenge.ui.composables.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.circularShape
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun CircularImage(
    imageResource: String,
    modifier: Modifier,
    imageViewSize: Int
) {
    Image(
        painter = rememberCoilPainter(request = imageResource, previewPlaceholder = R.drawable.twitter_logo) ,
        null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(imageViewSize.dp)
            .clip(
                shape = circularShape
            ),
    )
}