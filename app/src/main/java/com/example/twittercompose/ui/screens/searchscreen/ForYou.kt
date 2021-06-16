package com.example.twittercompose.ui.screens.searchscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twittercompose.R
import com.example.twittercompose.domain.ForYouModel
import com.example.twittercompose.domain.TextOnImageModel
import com.example.twittercompose.ui.composables.text.BoldText
import com.example.twittercompose.ui.composables.text.GreyLightText
import com.example.twittercompose.ui.theme.grey
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ForYouLayout(
    dataState: SearchScreenVM.ForYouState
) {
    when(dataState) {
        is SearchScreenVM.ForYouState.Loading -> {

        }
        is SearchScreenVM.ForYouState.Success -> {
            val forYouListData = dataState.data
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )

            LazyColumn {
                items(forYouListData) { forYouModel ->
                    key(forYouModel.id) {
                        ForYouItem(forYouModel)
                        Divider(thickness = (0.8).dp)
                    }
                }
            }
        }
        is SearchScreenVM.ForYouState.Error -> {

        }
    }
}

@Composable
fun TextOnImage(
    model: TextOnImageModel,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            //modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = rememberCoilPainter(request = model.imageUrl,
                            previewPlaceholder = R.drawable.my_pic),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            HeadingSubHeadingLayout(
                model.headingText,
                model.subHeadingText
            )
        }

    }
}

@Composable
fun HeadingSubHeadingLayout(
    headingText: String,
    subHeadingText: String,
) {
    Column(
        Modifier
            .padding(16.dp)
            .absoluteOffset(0.dp, 100.dp)
    ) {
        Text(
            text = headingText,
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = subHeadingText,
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun ForYouItem(
    model: ForYouModel
) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = model.title,
                style = TextStyle(
                    color = grey,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            BoldText(
                text = model.heading,
                fontSize = 14.sp
            )

            GreyLightText(
                text = model.additionalComment,
                fontSize = 12.sp,
                modifier = Modifier
            )
        }

}