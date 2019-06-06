package com.example.user.fcmapplication.network.service;

import com.squareup.okhttp.RequestBody;

import retrofit.Call;

/**
 * Created by KT on 23/12/15.
 */
public interface UserAPIService {
    Call<String> postFcmToken(RequestBody requestBody);
}
