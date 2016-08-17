package com.example.ramon.sessioncontrol;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ramon on 8/9/2016.
 */
public class MainLogged extends AppCompatActivity{
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.appbar) Toolbar appbar;
    @BindView(R.id.scrimInsetsFrameLayout) ScrimInsetsFrameLayout sifl;
    @BindView(R.id.navdrawerlist) ListView ndList;
    @BindView(R.id.noteList) ListView noteListView;

    private ArrayList<String> noteList;
    private ActionBarDrawerToggle drawerToggle;
    private ArrayAdapter<String> listAdapter;
    public static final String MyPreferences = "MyPreferences";

    SharedPreferences UserLog;
    SharedPreferences.Editor UserLogEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserLog = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        noteList = new ArrayList<>();
        noteList.add("Example note");

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteList);

        setContentView(R.layout.activity_logged);
        ButterKnife.bind(this);
        setSupportActionBar(appbar);

        final String[] options = new String[]{"","","","","","Logout", "Exit App"};

        ArrayAdapter<String> ndMenuAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_activated_1, options);

        ndList.setAdapter(ndMenuAdapter);

        ndList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 5:
                        logout();
                        break;
                    case 6:
                        close();
                        break;
                }

                ndList.setItemChecked(position,true);

                getSupportActionBar().setTitle(options[position]);

                drawerLayout.closeDrawer(sifl);
            }
        });

        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        int id = item.getItemId();

        noteListView.setAdapter(listAdapter);
        if(id == R.id.action_add_note){
            final EditText taskEditText = new EditText(this);
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Add a note")
                    .setView(taskEditText)
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String note = taskEditText.getText().toString();
                            noteList.add(note);
                            BasicUser user = new BasicUser();
                            user.setNotesList(noteList);
                            String UserInfoGson = new Gson().toJson(user);

                            UserLogEditor = UserLog.edit();
                            UserLogEditor.putString("UserInfo" , UserInfoGson);
                            UserLogEditor.apply();
                            listAdapter.notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();
            dialog.show();

        }

        return super.onOptionsItemSelected(item);
    }

    public void logout(){
        confirmLogout();
    }

    public void close(){
        finish();
    }

    public void confirmLogout(){
        DialogFragment newFragment = new LogoutDialog();
        newFragment.show(getFragmentManager(), "logout");
    }

}
