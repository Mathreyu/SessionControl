package com.example.ramon.sessioncontrol;

import android.app.Activity;
import android.app.DialogFragment;
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
        confirmLogout();
    }

    public void close(View view){
        finish();
    }

    public void confirmLogout(){
        DialogFragment newFragment = new LogoutDialog();
        newFragment.show(getFragmentManager(), "logout");
    }
}
