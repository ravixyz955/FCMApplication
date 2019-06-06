package com.example.user.fcmapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.user.fcmapplication.constants.Constants;
import com.example.user.fcmapplication.network.service.UserAPIService;
import com.example.user.fcmapplication.utils.DataUtils;
import com.example.user.fcmapplication.utils.NetworkUtils;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.post_token_btn)
    Button post_btn;
    private UserAPIService userAPIService;
    private JSONObject fcmToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        userAPIService = NetworkUtils.provideUserAPIService(this);
        /*
         * If the device is having android oreo we will create a notification channel
         * */


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(Constants.CHANNEL_ID, Constants.CHANNEL_NAME, importance);
            mChannel.setDescription(Constants.CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mNotificationManager.createNotificationChannel(mChannel);
        }

//        MyNotificationManager.getInstance(this).displayNotification("Greetings", "Hello how are you?");

    }

    @OnClick(R.id.post_token_btn)
    public void sendToken() {
        fcmToken = new JSONObject();
        try {
            Log.d("TOKEN", "sendToken: " + fcmToken);
            fcmToken.put("registrationToken", DataUtils.getToken(MainActivity.this));
            final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), fcmToken.toString());
            userAPIService.postFcmToken(requestBody).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Response<String> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        Log.d("Success:", "onResponse: " + "Success");
                    } else {
                        Log.d("Error:", "onResponse: " + "Error");
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("Failure", "onFailure: " + t.getMessage());
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}