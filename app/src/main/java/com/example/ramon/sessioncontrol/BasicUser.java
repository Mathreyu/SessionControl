package com.example.ramon.sessioncontrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ramon on 8/9/2016.
 */
public class BasicUser {
    @Expose
    @SerializedName("name")
    String name;
    @Expose
    @SerializedName("password")
    String password;
    @Expose
    @SerializedName("Notes")
    ArrayList<String> notesList;

    //region getters and setters
    public ArrayList<String> getNotesList() {
        return notesList;
    }

    public void setNotesList(ArrayList<String> notesList) {
        this.notesList = notesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion

}
