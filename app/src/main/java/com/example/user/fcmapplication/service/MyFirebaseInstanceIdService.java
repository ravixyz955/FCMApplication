package com.example.user.fcmapplication.service;

import android.util.Log;

import com.example.user.fcmapplication.utils.DataUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private String token;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        token = FirebaseInstanceId.getInstance().getToken();
        DataUtils.saveToken(this, token);
        Log.d("MyRefreshedToken", token);
    }
}