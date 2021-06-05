package com.example.androiddevchallenge.ui.composables.tweet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.tweetActionItemsHeight
import com.example.androiddevchallenge.ui.theme.tweetActionItemsWidth

@Composable
fun Share() {
    Surface {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = null,
                modifier = Modifier.size(tweetActionItemsWidth, tweetActionItemsHeight)
            )
        }
    }
}

@Preview
@Composable
fun SharePreview() {
    Share()
}