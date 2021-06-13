package com.example.androiddevchallenge.ui.composables.drawer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.domain.UserModel
import com.example.androiddevchallenge.ui.composables.image.CircularImage
import com.example.androiddevchallenge.ui.composables.text.UserHandleText
import com.example.androiddevchallenge.ui.composables.text.UserNameBold
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import com.example.androiddevchallenge.ui.theme.grey
import com.example.androiddevchallenge.ui.theme.myProfilePictureUrl
import com.example.androiddevchallenge.ui.theme.twitterBlue
import com.example.androiddevchallenge.utils.Screens

private val drawerOptions = listOf(
    Screens.DrawerOptions.Profile,
    Screens.DrawerOptions.Lists,
    Screens.DrawerOptions.Topics,
    Screens.DrawerOptions.Bookmarks,
    Screens.DrawerOptions.Moments,
    Screens.DrawerOptions.SettingsAndPrivacy,
    Screens.DrawerOptions.HelpCentre
)

@Composable
fun NavigationDrawer(
    currentUser: UserModel,
    onThemeChanged: () -> Unit,
    baseApplication: TwitterApplication
) {
    TwitterTheme(
        darkTheme = baseApplication.isGlobalDarkTheme.value
    ) {
        Column {
            Column(
                Modifier.padding(start = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(12.dp))

                CircularImage(
                    imageResource = myProfilePictureUrl,
                    modifier = Modifier,
                    imageViewSize = 55
                )

                Spacer(modifier = Modifier.height(12.dp))

                UserNameBold(
                    name = currentUser.username,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                UserHandleText(
                    handleName = currentUser.userHandle,
                    fontSize = 16.sp,
                    modifier = Modifier
                )

                Spacer(modifier = Modifier.height(15.dp))

                FollowersAndFollowingRow(
                    currentUser
                )

                Spacer(modifier = Modifier.height(15.dp))
            }

            Divider()

            DrawerOptionsList(baseApplication)

            DrawerFooter(
                onThemeChanged
            )
        }
    }
}

@Composable
fun DrawerFooter(
    onThemeChanged: () -> Unit
) {
    Column(
        Modifier.height(200.dp)
    ) {
        Divider()
        Row(
            modifier = Modifier
                .height(34.dp)
                .fillMaxWidth()
                .padding(top = 3.dp, bottom = 3.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            ) {
                ThemeChangeIcon (
                    onThemeChanged
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.End)
            ) {
                QRIcon()
            }
        }
    }
}

@Composable
fun FollowersAndFollowingRow(
    currentUser: UserModel
) {
    Row {
        UserNameBold(
            name = currentUser.followingCount.toString(),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.width(4.dp))

        UserHandleText(
            handleName = "Following",
            fontSize = 14.sp,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.width(12.dp))

        UserNameBold(
            name = currentUser.followersCount.toString(),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.width(4.dp))

        UserHandleText(
            handleName = "Followers",
            fontSize = 14.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun DrawerOptionsList(baseApplication: TwitterApplication) {
    LazyColumn {
        items(drawerOptions) { drawerOption ->
            key(drawerOption.title) {
                TwitterTheme(darkTheme = baseApplication.isGlobalDarkTheme.value) {
                    NavigationOptionRow(
                        hasIcon = drawerOption.hasIcon,
                        iconResource = drawerOption.iconResource,
                        optionText = drawerOption.title
                    )

                    if (drawerOption.title == "Moments") {
                        Divider()
                    }
                }

            }
        }
    }
}

@Composable
fun NavigationOptionRow(
    hasIcon: Boolean,
    iconResource: Int,
    optionText: String
) {
    Row(
        Modifier.padding(16.dp)
    ) {
        if (hasIcon) {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                tint = grey
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = optionText,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
fun ThemeChangeIcon(onThemeChanged: () -> Unit) {
    IconButton(
        onClick = onThemeChanged,
        modifier = Modifier
            .wrapContentWidth(Alignment.Start)
            .padding(start = 2.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_lamp),
            contentDescription = null,
            tint = twitterBlue,
            modifier = Modifier.wrapContentWidth(Alignment.Start)
        )
    }
}

@Composable
fun QRIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_qr),
        contentDescription = null,
        tint = twitterBlue,
        modifier = Modifier
            .wrapContentWidth(Alignment.End)
            .padding(end = 16.dp)
    )
}
