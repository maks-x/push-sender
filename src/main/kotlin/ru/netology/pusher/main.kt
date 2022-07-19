package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val messageForLike = Message.builder()
        .putData("action", "LIKE")
        .putData(
            "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent()
        )
        .setToken("fxKfcMqNSKCYjwQv8jmP7n:APA91bEQstRSbPR_SsAmjCGKOsKBFLzGJSQ4TJyVZw8WCS5Y7RkI429xqjKuz59Gd1byglc2sQ684Mm_6g37nzxczub50zRfbss7vMxm8lFmjM-1pRxN3XKFX1IbwDfG6YsWqEXc5t9K")
        .build()

    FirebaseMessaging.getInstance().send(messageForLike)

    val messageForNewPost = Message.builder()
        .putData("action", "NEW_POST")
        .putData(
            "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 99,
          "text": "Это текст поста, отправленного мной, Василием Фаербэйзовичем Пушсендеровым, дабы Максим Николаевич смог продемонстрировать своё понимание текущей темы"
        }""".trimIndent()
        )
        .setToken("fxKfcMqNSKCYjwQv8jmP7n:APA91bEQstRSbPR_SsAmjCGKOsKBFLzGJSQ4TJyVZw8WCS5Y7RkI429xqjKuz59Gd1byglc2sQ684Mm_6g37nzxczub50zRfbss7vMxm8lFmjM-1pRxN3XKFX1IbwDfG6YsWqEXc5t9K")
        .build()

    FirebaseMessaging.getInstance().send(messageForNewPost)
}
