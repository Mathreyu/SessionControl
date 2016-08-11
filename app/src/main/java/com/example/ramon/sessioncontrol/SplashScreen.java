package com.example.ramon.sessioncontrol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.widget.ImageView;

import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by Ramon on 8/9/2016.
 */
public class SplashScreen extends Activity{

    public static final String MyPreferences = "MyPreferences";
    SharedPreferences MyPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        MyPrefs = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
        final String userJson = MyPrefs.getString("UserInfo","");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkLogin(userJson);
            }
        }, 1500);
    }

    public void checkLogin(String userJson){
        Intent intent;
        if (!userJson.isEmpty()) {
            intent = new Intent(SplashScreen.this, MainLogged.class);
        }
        else{
            intent = new Intent(SplashScreen.this, MainLogin.class);
        }
        startActivity(intent);
        finish();
    }
}
