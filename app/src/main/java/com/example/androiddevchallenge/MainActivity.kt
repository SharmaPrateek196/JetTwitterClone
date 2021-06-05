package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.composables.story.StoryPalette
import com.example.androiddevchallenge.ui.theme.TwitterTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
//        LazyColumn() {
//            for (i in 1..9) {
//                item {
////                    Tweet(
////                        tweeterName = "Prateek Sharma",
////                        handleName = "@prateekshow",
////                        timeTweeted = "2h",
////                        isVerified = false,
////                        imageResource = R.drawable.twitter_logo,
////                        "563",
////                        "6,739",
////                        "12,653",
////                        modifier = Modifier
////                    )
//                    StoryUnseenThumbnail(imageResource = R.drawable.twitter_logo, modifier = Modifier, imageViewSize = 35)
//                    StorySeenThumbnail(imageResource = R.drawable.twitter_logo, modifier = Modifier, imageViewSize = 35)
//                    Divider(thickness = 1.dp, color = dividerColor)
//                }
//            }
//        }
        
        StoryPalette(modifier = Modifier)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    TwitterTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    TwitterTheme(darkTheme = true) {
        MyApp()
    }
}
