package com.example.twittercompose.ui.composables.bars

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twittercompose.R
import com.example.twittercompose.ui.theme.*

@Composable
fun TwitterTopAppBar(
    onMenuClicked: () -> Unit,
    hasSearchBar: Boolean,
    searchHint: String = "",
    hasSettings: Boolean
) {
    TopAppBar(
        elevation = 0.dp
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onMenuClicked,
                modifier = Modifier.fillMaxHeight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 4.dp)
                        .weight(1f, false),
                    tint = twitterBlue,
                )
            }

            if (hasSearchBar) {
                Box(
                    modifier = Modifier.weight(5f)
                ) {
                    SearchBar(
                        searchHint = searchHint
                    )
                }
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_twitter),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(5f, true)
                        .size(24.dp),
                    tint = twitterBlue
                )
            }

            if(hasSettings) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                        .weight(1f, true),
                    tint = twitterBlue
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_timeline),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                        .weight(1f, true),
                    tint = twitterBlue
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    searchHint: String
) {
    Surface(
        shape = RoundedCornerShape(60),
        border = BorderStroke(0.5.dp, grey),
        color = MaterialTheme.colors.secondary,
        modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth()
            .padding(start = 18.dp, end = 1.dp, top = 2.dp, bottom = 1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(2.dp),
        ) {
            Text(
                text = searchHint,
                color = MaterialTheme.colors.onSecondary,
                maxLines = 1,
                style = TextStyle(
                    fontSize = 16.sp
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }

}