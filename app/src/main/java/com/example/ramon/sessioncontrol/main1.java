package com.example.ramon.sessioncontrol;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
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

        go = (Button)findViewById(R.id.login);
        sharedPreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = user.getText().toString();
                String password = pass.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name, name);
                editor.putString(Pass, password);
                editor.commit();

                intent = new Intent(main1.this, main2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
