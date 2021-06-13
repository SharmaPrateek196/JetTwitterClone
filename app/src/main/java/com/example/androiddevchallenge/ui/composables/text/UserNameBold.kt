package com.example.androiddevchallenge.ui.composables.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.blackLessDark
import com.example.androiddevchallenge.ui.theme.grey
import com.example.androiddevchallenge.ui.theme.purple700

@Composable
fun UserNameBold(
    name: String,
    fontSize: TextUnit
) {
    Surface {
        Text(
            text = name,
            style = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold,
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun UserNameBoldPreview() {
    UserNameBold(name = "Prateek Sharma", 12.sp)
}