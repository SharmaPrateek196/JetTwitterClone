package com.example.androiddevchallenge.ui.composables.topbar

import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R

@Composable
fun MainTopAppBar() {
    TopAppBar(
        title = { TwitterIcon(Modifier) },
        navigationIcon = { MenuIcon(Modifier) }
    )
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
    Icon(
        painter = painterResource(id = R.drawable.ic_twitter),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun MenuIcon(
    modifier: Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_menu),
        contentDescription = null,
        modifier = modifier
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