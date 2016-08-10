package com.example.ramon.sessioncontrol;

import android.app.Activity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkLogin();
            }
        }, 3000);

    }

    public void checkLogin(){

    }
}
