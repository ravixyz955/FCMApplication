package com.example.user.fcmapplication.service;

import com.example.user.fcmapplication.MyNotificationManager;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    String title, body;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().size() > 0) {
            //handle the data message here
        }

        //getting the title and the body
        title = remoteMessage.getNotification().getTitle();
        body = remoteMessage.getNotification().getBody();

        MyNotificationManager.getInstance(this).displayNotification(title, body);
    }
}