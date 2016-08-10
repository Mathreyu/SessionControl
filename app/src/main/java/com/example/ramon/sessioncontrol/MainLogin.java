package com.example.ramon.sessioncontrol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainLogin extends Activity {
    @BindView(R.id.nameKey) EditText userName;
    @BindView(R.id.passKey) EditText pass;
    @BindView(R.id.login) Button go;

    public static final String MyPreferences = "MyPreferences";

    SharedPreferences UserLog;
    SharedPreferences.Editor UserLogEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);
        UserLog = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        init();
    }

    private void init() {
        initListeners();
    }

    private void initListeners() {
        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String password = pass.getText().toString();
                BasicUser user = new BasicUser();
                user.setName(name);
                user.setPassword(password);
                String UserInfoGson = new Gson().toJson(user);

                UserLogEditor = UserLog.edit();
                UserLogEditor.putString("UserInfo" , UserInfoGson);
                UserLogEditor.apply();

                Intent intent = new Intent(MainLogin.this, MainLogged.class);
                intent.putExtra("UserInfo", UserInfoGson);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
