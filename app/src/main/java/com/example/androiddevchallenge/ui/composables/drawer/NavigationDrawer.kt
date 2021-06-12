package com.example.androiddevchallenge.ui.composables.drawer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.UserModel
import com.example.androiddevchallenge.ui.composables.image.CircularImage
import com.example.androiddevchallenge.ui.composables.text.UserHandleText
import com.example.androiddevchallenge.ui.composables.text.UserNameBold
import com.example.androiddevchallenge.ui.theme.myProfilePictureUrl

private val drawerOptions = listOf(
    DrawerOptions.Profile,
    DrawerOptions.Lists,
    DrawerOptions.Topics,
    DrawerOptions.Bookmarks,
    DrawerOptions.Moments,
    DrawerOptions.SettingsAndPrivacy,
    DrawerOptions.HelpCentre
)


@Composable
fun NavigationDrawer(
    modifier: Modifier,
    currentUser: UserModel
) {
    Column(
        Modifier.padding(start = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        CircularImage(
            imageResource = myProfilePictureUrl,
            modifier = Modifier,
            imageViewSize = 50
        )

        Spacer(modifier = Modifier.height(12.dp))

        UserNameBold(
            name = currentUser.username,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        UserHandleText(
            handleName = currentUser.userHandle,
            fontSize = 13.sp,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(18.dp))

        FollowersAndFollowingRow(
            currentUser
        )

        Spacer(modifier = Modifier.height(20.dp))

        Divider()

        DrawerOptionsList()

    }
}

@Composable
fun FollowersAndFollowingRow(
    currentUser: UserModel
) {
    Row {
        UserNameBold(
            name = currentUser.followingCount.toString(),
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.width(4.dp))

        UserHandleText(
            handleName = "Following",
            fontSize = 16.sp,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.width(12.dp))

        UserNameBold(
            name = currentUser.followersCount.toString(),
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.width(4.dp))

        UserHandleText(
            handleName = "Following",
            fontSize = 16.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun DrawerOptionsList() {
    LazyColumn {
        items(drawerOptions) { drawerOption ->
            key(drawerOption.title) {
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
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = optionText,
            fontSize = 16.sp
        )
    }
}

sealed class DrawerOptions(val hasIcon: Boolean, @DrawableRes val iconResource: Int, val title: String, val route: String) {
    object Profile : DrawerOptions(true, R.drawable.ic_person, "Profile", "profile")
    object Lists : DrawerOptions(true, R.drawable.ic_lists, "Lists", "lists")
    object Topics : DrawerOptions( true, R.drawable.ic_comment, "Topics", "topics")
    object Bookmarks : DrawerOptions( true, R.drawable.ic_bookmark, "Bookmarks", "bookmarks")
    object Moments : DrawerOptions( true, R.drawable.ic_heart, "Moments", "moments")
    object SettingsAndPrivacy : DrawerOptions( false, 0,"Settings And Privacy", "settings_and_privacy")
    object HelpCentre : DrawerOptions( false, 0, "Help Centre", "help_centre")
}