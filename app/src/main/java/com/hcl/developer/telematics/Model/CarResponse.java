package com.hcl.developer.telematics.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nirmal.ku on 9/13/2017.
 */

public class CarResponse extends BaseObservable{
    @SerializedName("id")
    private String id;
    @SerializedName("username")
    private String username;
    @SerializedName("carRegistrationNumber")
    private String carRegistrationNumber;
    @SerializedName("carStatus")
    private String carStatus;
    @SerializedName("totalTrip")
    private String totalTrip;
    @SerializedName("mileagePerLitter")
    private String mileagePerLiter;
    @SerializedName("lastServiceDate")
    private String lastServiceDate;
    @SerializedName("farePerMile")
    private String farePerMile;
    @SerializedName("carImage")
    private String carImage;
    @SerializedName("latitudeValue")
    private Double latitudeValue;
    @SerializedName("longitudeValue")
    private Double longitudeValue;
    @SerializedName("carType")
    private String carType;

    public CarResponse(String id, String username, String carRegistrationNumber, String carStatus, String totalTrip, String mileagePerLiter, String lastServiceDate, String farePerMile, String carImage, Double latitudeValue, Double longitudeValue, String carType) {
        this.id = id;
        this.username = username;
        this.carRegistrationNumber = carRegistrationNumber;
        this.carStatus = carStatus;
        this.totalTrip = totalTrip;
        this.mileagePerLiter = mileagePerLiter;
        this.lastServiceDate = lastServiceDate;
        this.farePerMile = farePerMile;
        this.carImage = carImage;
        this.latitudeValue = latitudeValue;
        this.longitudeValue = longitudeValue;
        this.carType = carType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getTotalTrip() {
        return totalTrip;
    }

    public void setTotalTrip(String totalTrip) {
        this.totalTrip = totalTrip;
    }

    public String getMileagePerLiter() {
        return mileagePerLiter;
    }

    public void setMileagePerLiter(String mileagePerLiter) {
        this.mileagePerLiter = mileagePerLiter;
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
