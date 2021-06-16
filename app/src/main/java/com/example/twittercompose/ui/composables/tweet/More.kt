package com.example.twittercompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.twittercompose.R

@Composable
fun More(
    modifier: Modifier
) {
    Surface {
        Image(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = null,
            modifier = modifier
        )
    }
}