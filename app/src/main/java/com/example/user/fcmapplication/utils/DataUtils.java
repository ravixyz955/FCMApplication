package com.example.user.fcmapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class DataUtils {
    public static final String USER_PREF = "user_pref";
    private static final String KEY_FCM_TOKEN = "key_fcm_token";

    public static void saveToken(Context mContext, String mobile) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_FCM_TOKEN, mobile);
        editor.apply();
    }

    public static String getToken(Context mContext) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_FCM_TOKEN, null);
    }
}
