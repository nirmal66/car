package com.hcl.developer.telematics.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nirmal.ku on 9/13/2017.
 */

public class CarResponseLocation {

    @SerializedName("carRegistrationNumber")
    private String carRegistrationNumber;
    @SerializedName("latitudeValue")
    private Double latitudeValue;
    @SerializedName("longitudeValue")
    private Double longitudeValue;

    public CarResponseLocation(String carRegistrationNumber, Double latitudeValue, Double longitudeValue) {
        this.carRegistrationNumber = carRegistrationNumber;
        this.latitudeValue = latitudeValue;
        this.longitudeValue = longitudeValue;
    }

    public String getcarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setUserName(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
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
