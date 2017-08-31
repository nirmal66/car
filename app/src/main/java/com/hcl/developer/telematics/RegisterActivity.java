package com.hcl.developer.telematics;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.hcl.developer.telematics.Model.LoginResponse;
import com.hcl.developer.telematics.Model.RegisterRequest;
import com.hcl.developer.telematics.Utilities.BaseActivity;
import com.hcl.developer.telematics.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityRegisterBinding activityRegisterBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_register);

        activityRegisterBinding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterRequest register = new RegisterRequest(activityRegisterBinding.edtFirstName.getText().toString(),activityRegisterBinding.lastName.getText().toString(),activityRegisterBinding.lastName.getText().toString(),activityRegisterBinding.lastName.getText().toString(),activityRegisterBinding.lastName.getText().toString(),activityRegisterBinding.edtContactNumber.getText().toString(),activityRegisterBinding.edtUsername.getText().toString(),activityRegisterBinding.edtPassword.getText().toString());
                Call<LoginResponse> call = apiService.getRegister(register);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.body().getStatus().toString().equals("Success")) {
                            Intent mainActivity = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(mainActivity);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
            }
        });

    }
}