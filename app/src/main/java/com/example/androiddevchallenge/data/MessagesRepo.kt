package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.domain.MessageModel

object MessagesRepo {

    val messages = listOf(

        MessageModel(
            id = 0,
            username = "Sundar",
            userHandle = "@sundarpichaai",
            messageTime = "2m",
            messageText = "Offcourse, I invite you for the next Google I/O",
            userProfileUrl = "https://pbs.twimg.com/profile_images/864282616597405701/M-FEJMZ0_400x400.jpg"
        ),
        MessageModel(
            id = 1,
            username = "Deepika",
            userHandle = "@deepika",
            messageTime = "9m",
            messageText = "Hey Prateek, thank you so much for the treat!",
            userProfileUrl = "https://pbs.twimg.com/profile_images/1344886403444817920/uvBOq5Wc_400x400.jpg"
        ),
        MessageModel(
            id = 2,
            username = "Dr Kumar",
            userHandle = "@DrKumarVisvas",
            messageTime = "11 Jun",
            messageText = "Yeah, but that poem still causes goosebumps!",
            userProfileUrl = "https://pbs.twimg.com/profile_images/1403668022045204480/YtjEQg6d_400x400.jpg"
        ),
        MessageModel(
            id = 3,
            username = "Ajay Devgn",
            userHandle = "@ajaydvgn",
            messageTime = "8 Jun",
            messageText = "We are also waiting for the same!",
            userProfileUrl = "https://pbs.twimg.com/profile_images/1380474232258240521/ODuoj6j5_400x400.jpg"
        ),
        MessageModel(
            id = 4,
            username = "Kapil Sharma",
            userHandle = "@kapilsharma",
            messageTime = "2 Jun",
            messageText = "Yup Prateek, we are planning to have the same this month as well!",
            userProfileUrl = "https://pbs.twimg.com/profile_images/1152215560869953536/mSjwFhbF_400x400.jpg"
        )

    )

}