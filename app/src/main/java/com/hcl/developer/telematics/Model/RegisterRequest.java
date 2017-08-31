package com.hcl.developer.telematics.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nirmal.ku on 8/28/2017.
 */

public class RegisterRequest {

    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("dob")
    private String dob;
    @SerializedName("license")
    private String license;
    @SerializedName("address")
    private String address;
    @SerializedName("contactNumber")
    private String contactNumber;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;


    public RegisterRequest(String firstName, String lastName, String dob, String license, String address, String contactNumber, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.license = license;
        this.address = address;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
