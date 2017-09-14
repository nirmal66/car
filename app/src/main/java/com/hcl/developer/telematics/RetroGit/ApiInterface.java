package com.hcl.developer.telematics.RetroGit;

import com.hcl.developer.telematics.Model.CarRegister;
import com.hcl.developer.telematics.Model.CarRequest;
import com.hcl.developer.telematics.Model.CarResponse;
import com.hcl.developer.telematics.Model.CarResponseLocation;
import com.hcl.developer.telematics.Model.Login;
import com.hcl.developer.telematics.Model.LoginResponse;
import com.hcl.developer.telematics.Model.RegisterRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by nirmal.ku on 8/28/2017.
 */

public interface ApiInterface {


    @POST("login")
    Call<LoginResponse> getLogin(@Body Login loginRequest);

    @POST("create")
    Call<LoginResponse> getRegister(@Body RegisterRequest registerRequest);

    @POST("reset")
    Call<LoginResponse> getReset(@Body Login loginRequest);

    @POST("carregistration")
    Call<LoginResponse> getCarRegister(@Body CarRegister carRegister);

    @POST("showcars")
    Call<List<CarResponse>> getCarList(@Body CarRequest carRequest);

    @POST("getcarlocation")
    Call<List<CarResponseLocation>> getCarLocation(@Body CarRequest carRequest);

}
