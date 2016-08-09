package com.example.ramon.sessioncontrol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class main1 extends AppCompatActivity {

    EditText user, pass;
    Button go;
    Intent intent;

    public static final String MyPrefs = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Pass = "passKey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        user = (EditText)findViewById(R.id.nameKey);
        pass = (EditText)findViewById(R.id.passKey);
    }
}
