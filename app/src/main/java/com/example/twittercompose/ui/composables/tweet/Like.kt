package com.example.twittercompose.ui.composables.tweet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.twittercompose.R
import com.example.twittercompose.ui.theme.grey
import com.example.twittercompose.ui.theme.tweetActionItemsFontSize
import com.example.twittercompose.ui.theme.tweetActionItemsHeight
import com.example.twittercompose.ui.theme.tweetActionItemsWidth

@Composable
fun Like(
    totalLikes: Int
) {
    Surface {
        SelectionContainer {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(width = 64.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier.size(tweetActionItemsWidth-1.dp, tweetActionItemsHeight-1.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = totalLikes.toString(),
                    style = TextStyle(
                        color = grey,
                        fontSize = tweetActionItemsFontSize
                    )
                )
            }
        }
    }
}
