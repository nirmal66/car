package com.hcl.developer.telematics.SessionManager;

import android.content.Context;
import android.content.SharedPreferences;

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
    public static final String IS_LOGIN = "IsLoggedIn";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(prefName, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void Login(String username,String password)
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(key_NAME, username);
        editor.putString(key_PASS, password);
        editor.commit();
    }

    public String getUsername()
    {
        return pref.getString(key_NAME,null);
    }

    public boolean CheckLogin()
    {
        return pref.getBoolean(IS_LOGIN,false);
    }

}
