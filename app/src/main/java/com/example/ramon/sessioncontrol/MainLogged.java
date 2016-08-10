package com.example.ramon.sessioncontrol;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;

/**
 * Created by Ramon on 8/9/2016.
 */
public class MainLogged extends Activity{
    @BindView(R.id.logout) Button logout;
    @BindView(R.id.exit) Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        logout = (Button) findViewById(R.id.logout);
        close = (Button) findViewById(R.id.exit);
    }

    public void logout(View view){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String UserExtras =  extras.getString("basic_user", "");
            SharedPreferences sharedPreferences = getSharedPreferences(MainLogin.MyPreferences, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(UserExtras);
            editor.commit();
        }

    }

    public void close(View view){
        finish();
    }
}
