package com.hcl.developer.telematics.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nirmal.ku on 8/28/2017.
 */

public class ForgotPassword {

    @SerializedName("username")
    private String userName;
    @SerializedName("password")
    private String passWord;

    public ForgotPassword(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
