package com.example.user.fcmapplication.network;

import android.content.Context;

import com.example.user.fcmapplication.network.service.UserAPIService;
import com.example.user.fcmapplication.utils.NetworkUtils;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.net.Proxy;

/**
 * Created by apple on 23/01/18.
 */

public class TokenAuthenticator implements Authenticator {

    private static final String AUTHORIZATION = "x-auth-token";
    private Context mContext;
    private String newAccessToken;

    private UserAPIService userAPIService;

    public TokenAuthenticator(Context mContext) {
        this.mContext = mContext;
        userAPIService = NetworkUtils.provideUserAPIService(mContext);
    }

    @Override
    public Request authenticate(Proxy proxy, Response response) {
        return null;
    }

    @Override
    public Request authenticateProxy(Proxy proxy, Response response) {
        // Null indicates no attempt to authenticate.
        return null;
    }
}