package com.example.twittercompose.ui.composables.tweet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.twittercompose.R
import com.example.twittercompose.ui.theme.tweetActionItemsHeight
import com.example.twittercompose.ui.theme.tweetActionItemsWidth

@Composable
fun Share() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_share),
            contentDescription = null,
            modifier = Modifier.size(tweetActionItemsWidth, tweetActionItemsHeight)
        )
    }
}

@Preview
@Composable
fun SharePreview() {
    Share()
}