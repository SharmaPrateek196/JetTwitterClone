package com.example.twittercompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.twittercompose.R
import com.example.twittercompose.domain.TweetModel
import com.example.twittercompose.ui.composables.image.CircularImage
import com.example.twittercompose.ui.composables.image.TweetImage
import com.example.twittercompose.ui.composables.text.GreyLightText
import com.example.twittercompose.ui.composables.text.BoldText
import com.example.twittercompose.ui.composables.tweet.Comment
import com.example.twittercompose.ui.composables.tweet.Like
import com.example.twittercompose.ui.composables.tweet.Retweet
import com.example.twittercompose.ui.composables.tweet.Share
import com.example.twittercompose.ui.theme.*

@Composable
fun Tweet(
    tweet: TweetModel,
    modifier: Modifier
) {

    Surface {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                .height(IntrinsicSize.Max)
        ) {
            CircularImage(
                imageResource = tweet.userImageResource,
                modifier = modifier,
                imageViewSize = 45
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier.height(
                    IntrinsicSize.Max
                )
            ) {
                Row(Modifier.height(IntrinsicSize.Max)) {
                    BoldText(text = tweet.tweeterName, fontSize = usernameSize)
                    if(tweet.isVerified) {
                        Image(
                            painter = painterResource(R.drawable.ic_verified_tick),
                            contentDescription = null,
                            Modifier.padding(3.dp)
                        )
                    }
                    GreyLightText(
                        text = tweet.handleName,
                        fontSize = userHandleSize,
                        modifier = Modifier.padding(start = 3.dp)
                    )
                    Text(
                        text = tweet.timeTweeted,
                        color = grey,
                        fontSize = timeTextSize,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                    Row(
                        Modifier.fillMaxSize(32f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        More(modifier = Modifier.padding(start = 4.dp, top = 4.dp, bottom = 4.dp))
                        Spacer(Modifier.width(4.dp))
                    }
                }
                Text(
                    text = tweet.tweetText,
                    fontSize = tweetTextSize
                )
                if (tweet.hasImage) {
                    Spacer(modifier = Modifier.height(4.dp))
                    TweetImage(
                        imageResource = tweet.imageResource,
                        modifier = Modifier//.height(95.dp)
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Comment(tweet.totalComments)
                    Retweet(tweet.totalRetweets)
                    Like(tweet.totalLikes)
                    Share()
                }
            }
        }
    }

}