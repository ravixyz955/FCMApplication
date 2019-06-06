package com.example.user.fcmapplication.network.service;

import com.example.user.fcmapplication.network.RemoteServerAPI;
import com.squareup.okhttp.RequestBody;

import retrofit.Call;

/**
 * Created by KT on 23/12/15.
 */
public class UserAPIServiceImpl implements UserAPIService {

    private final RemoteServerAPI remoteServerAPI;

    public UserAPIServiceImpl(RemoteServerAPI remoteServerAPI) {
        this.remoteServerAPI = remoteServerAPI;
    }

    @Override
    public Call<String> postFcmToken(RequestBody requestBody) {
        return remoteServerAPI.postFcmToken(requestBody);
    }
}