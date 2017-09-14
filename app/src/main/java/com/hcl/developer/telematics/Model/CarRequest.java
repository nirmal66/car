package com.hcl.developer.telematics.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nirmal.ku on 9/13/2017.
 */

public class CarRequest {

    @SerializedName("username")
    private String userName;
    @SerializedName("latitudeValue")
    private Double latitudeValue;
    @SerializedName("longitudeValue")
    private Double longitudeValue;

    public CarRequest(String userName, Double latitudeValue, Double longitudeValue) {
        this.userName = userName;
        this.latitudeValue = latitudeValue;
        this.longitudeValue = longitudeValue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getLatitudeValue() {
        return latitudeValue;
    }

    public void setLatitudeValue(Double latitudeValue) {
        this.latitudeValue = latitudeValue;
    }

    public Double getLongitudeValue() {
        return longitudeValue;
    }

    public void setLongitudeValue(Double longitudeValue) {
        this.longitudeValue = longitudeValue;
    }
}
