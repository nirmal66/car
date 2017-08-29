package com.hcl.developer.telematics.RetroGit;

import com.hcl.developer.telematics.Model.Login;
import com.hcl.developer.telematics.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by nirmal.ku on 8/28/2017.
 */

public interface ApiInterface {


    @POST("login")
    Call<LoginResponse> getLogin(@Body Login loginRequest);
}
