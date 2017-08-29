package com.hcl.developer.telematics.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nirmal.ku on 8/28/2017.
 */

public class LoginResponse {

    @SerializedName("status")
    private String status;

    public LoginResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
