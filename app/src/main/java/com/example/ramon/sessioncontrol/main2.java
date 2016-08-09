package com.example.ramon.sessioncontrol;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ramon on 8/9/2016.
 */
public class main2 extends Activity{
    Button logout = null;
    Button close = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        logout = (Button) findViewById(R.id.logout);
        close = (Button) findViewById(R.id.exit);
    }

    public void logout(View view){
        SharedPreferences sharedPreferences = getSharedPreferences(main1.MyPrefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void close(View view){
        finish();
    }
}
