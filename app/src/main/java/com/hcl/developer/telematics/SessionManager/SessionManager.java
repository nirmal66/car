package com.hcl.developer.telematics.SessionManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.hcl.developer.telematics.LoginActivity;

/**
 * Created by nirmal.ku on 9/6/2017.
 */

public class SessionManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final int PRIVATE_MODE = 0;
    private static final String prefName = "idlePref";
    public static final String key_NAME = "username";
    public static final String key_PASS = "password";
    public static final String key_ROLE = "role";
    public static final String IS_LOGIN = "IsLoggedIn";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(prefName, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void Login(String username,String password,String role)
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(key_NAME, username);
        editor.putString(key_PASS, password);
        editor.putString(key_ROLE, role);
        editor.commit();
    }

    public String getUsername()
    {
        return pref.getString(key_NAME,null);
    }

    public String getRole()
    {
        return pref.getString(key_ROLE,null);
    }

    public boolean CheckLogin()
    {
        return pref.getBoolean(IS_LOGIN,false);
    }
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);
    }

}
