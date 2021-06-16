package com.example.twittercompose.ui.composables.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twittercompose.R
import com.example.twittercompose.domain.MessageModel
import com.example.twittercompose.ui.composables.image.CircularImage
import com.example.twittercompose.ui.composables.text.GreyLightText
import com.example.twittercompose.ui.composables.text.BoldText
import com.example.twittercompose.ui.theme.*

@Composable
fun Message(
    message: MessageModel,
    modifier: Modifier
) {
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                .height(IntrinsicSize.Max)
        ) {
            CircularImage(
                imageResource = message.userProfileUrl,
                modifier = Modifier.align(Alignment.CenterVertically),
                imageViewSize = 40
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
                    BoldText(text = message.username, fontSize = usernameSize)
                    if (message.isVerified) {
                        Image(
                            painter = painterResource(R.drawable.ic_verified_tick),
                            contentDescription = null,
                            Modifier.padding(3.dp).size(14.dp)
                        )
                    }
                    GreyLightText(
                        text = message.userHandle,
                        fontSize = userHandleSize,
                        modifier = Modifier.padding(start = 3.dp)
                    )
                    Text(
                        text = message.messageTime,
                        textAlign = TextAlign.End,
                        color = grey,
                        fontSize = timeTextSize,
                        modifier = Modifier.padding(start = 6.dp)
                            .fillMaxWidth()
                    )
                }

                Text(
                    text = message.messageText,
                    fontSize = 14.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = grey
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMessage() {
    Message(message = MessageModel(1, "Prateek Sharma", "@prateeksharma", messageTime = "20 jun", messageText = "this message tex is a little bit long, I am trying to span it to 2 lines but initially it could not be spread over two lines so I am again", userProfileUrl = myProfilePictureUrl), modifier = Modifier)
}