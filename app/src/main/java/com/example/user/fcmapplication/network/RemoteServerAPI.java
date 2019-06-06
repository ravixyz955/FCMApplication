package com.example.user.fcmapplication.network;

import com.example.user.fcmapplication.network.model.ActivateUserRequest;
import com.example.user.fcmapplication.network.model.AuthenticateUserRequest;
import com.example.user.fcmapplication.network.model.RegisterUserRequest;
import com.example.user.fcmapplication.network.model.User;
import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * Created by KT on 23/12/15.
 */
public interface RemoteServerAPI {

    String BASE_CONTEXT = "/api";

    @Multipart
    @POST(BASE_CONTEXT + "/users/image")
    Call<Void> uploadImage(@Header("x-auth-token") String fcmId, @Part("file") RequestBody request);

    @POST(BASE_CONTEXT + "/register")
    Call<User> registerUser(@Body RegisterUserRequest request);

    @POST("http://13.229.193.42:3000/api/authenticate")
    Call<User> authenticate(@Body AuthenticateUserRequest request);

    @POST("/activate")
    Call<Void> activateUser(@Body ActivateUserRequest request);

    @POST("http://192.168.1.194:3000/registrationtoken/save")
    Call<String> postFcmToken(@Body RequestBody requestBody);
}
