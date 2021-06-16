package com.example.twittercompose.ui.composables.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun BoldText(
    text: String,
    fontSize: TextUnit
) {
    Text(
        text = text,
        style = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
        ),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Preview
@Composable
fun UserNameBoldPreview() {
    BoldText(text = "Prateek Sharma", 12.sp)
}