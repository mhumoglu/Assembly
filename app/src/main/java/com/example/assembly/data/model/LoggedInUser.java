package com.example.assembly.data.model;

import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String username;
    private String bio;
    private String profile_url;

    public LoggedInUser(String json) throws JSONException {
        JSONObject reader = new JSONObject(json);
        this.userId = reader.getString("id");
        this.username = reader.getString("username");
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return username;
    }
}
