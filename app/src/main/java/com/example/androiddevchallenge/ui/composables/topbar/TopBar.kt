package com.example.androiddevchallenge.ui.composables.topbar

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
fun TweetsScreenAppBar(
    onMenuClicked: () -> Unit
) {
    TopAppBar(
//            title = { TwitterIcon(Modifier) },
//            navigationIcon = {
//                MenuIcon(
//                    Modifier,
//                    onMenuClicked
//                ) },
        elevation = 0.dp
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onMenuClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null,
                    modifier = Modifier
                        .height(27.dp)
                        .padding(start = 4.dp)
                        .weight(1f, false),
                    tint = twitterBlue,
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_twitter),
                contentDescription = null,
                modifier = Modifier
                    .weight(5f, true)
                    .size(24.dp),
                tint = twitterBlue
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_timeline),
                contentDescription = null,
                modifier = Modifier.size(22.dp)
                    .weight(1f, true),
                tint = twitterBlue
            )
        }
    }
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
                .offset((-25).dp),
            tint = twitterBlue
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
    modifier: Modifier,
    onMenuClicked: () -> Unit
) {
    IconButton(onClick = { onMenuClicked() }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null,
            modifier = modifier
                .size(25.dp)
                .offset(8.dp),
            tint = twitterBlue,
        )
    }
}

@Composable
fun TimelineIcon(
    modifier: Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_timeline),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = twitterBlue
    )
}