package com.example.androiddevchallenge.ui.composables.topbar

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.twitterBlue

@Composable
fun MainTopAppBar() {
    Surface {
        TopAppBar(
            title = { TwitterIcon(Modifier) },
            navigationIcon = { MenuIcon(Modifier) }
        )
    }
}

@Preview
@Composable
fun MainTopAppBarPreview() {
    MainTopAppBar()
}

@Composable
fun TwitterIcon(
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_twitter),
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.Center)
                .offset((-25).dp)
        )
        TimelineIcon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
        )
    }
}

@Composable
fun MenuIcon(
    modifier: Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_menu),
        contentDescription = null,
        modifier = modifier
            .size(25.dp)
            .offset(16.dp)
    )
}

@Composable
fun TimelineIcon(
    modifier: Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_timeline),
        contentDescription = null,
        modifier = modifier
    )
}