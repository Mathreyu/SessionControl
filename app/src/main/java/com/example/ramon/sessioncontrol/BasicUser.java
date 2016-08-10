package com.example.ramon.sessioncontrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

//region getters and setters
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
