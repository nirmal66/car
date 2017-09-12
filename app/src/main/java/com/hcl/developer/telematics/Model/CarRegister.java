package com.hcl.developer.telematics.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nirmal.ku on 9/12/2017.
 */

public class CarRegister {

    @SerializedName("username")
    private String userName;
    @SerializedName("carRegistrationNumber")
    private String carRegistrationNumber;
    @SerializedName("lastServiceDate")
    private String lastServiceDate;
    @SerializedName("farePerMile")
    private String farePerMile;
    @SerializedName("carImage")
    private String carImage;
    @SerializedName("carType")
    private String carType;

    public CarRegister(String userName, String carRegistrationNumber, String lastServiceDate, String farePerMile, String carImage, String carType) {
        this.userName = userName;
        this.carRegistrationNumber = carRegistrationNumber;
        this.lastServiceDate = lastServiceDate;
        this.farePerMile = farePerMile;
        this.carImage = carImage;
        this.carType = carType;
    }

    public CarRegister(String userName, String carRegistrationNumber, String lastServiceDate, String farePerMile, String carType) {
        this.userName = userName;
        this.carRegistrationNumber = carRegistrationNumber;
        this.lastServiceDate = lastServiceDate;
        this.farePerMile = farePerMile;
        this.carType = carType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public String getFarePerMile() {
        return farePerMile;
    }

    public void setFarePerMile(String farePerMile) {
        this.farePerMile = farePerMile;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
