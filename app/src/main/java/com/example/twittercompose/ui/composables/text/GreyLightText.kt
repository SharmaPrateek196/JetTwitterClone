package com.example.twittercompose.ui.composables.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.twittercompose.ui.theme.grey

@Composable
fun GreyLightText(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier
) {
    Text(
        text = text,
        style = TextStyle(
            color = grey,
            fontSize = fontSize,
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

@Preview
@Composable
fun UserHandleTextPreview() {
    GreyLightText(
        text = "@prateekSharma",
        fontSize = 12.sp,
        modifier = Modifier
    )
}