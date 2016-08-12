package com.example.ramon.sessioncontrol;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;

/**
 * Created by Ramon on 8/9/2016.
 */
public class MainLogged extends Activity{
    @BindView(R.id.logout) Button logout;
    @BindView(R.id.exit) Button close;
    @BindView(R.id.drawer_layout) DrawerLayout userInfoDrawer;
    @BindView(R.id.left_drawer) ListView userInfoList;
    private String[] optionItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        logout = (Button) findViewById(R.id.logout);
        close = (Button) findViewById(R.id.exit);

        initDrawer();
    }

    private void initDrawer() {
        userInfoList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, optionItems ));
        
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
