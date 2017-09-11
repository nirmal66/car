package com.hcl.developer.telematics;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.hcl.developer.telematics.Model.LoginResponse;
import com.hcl.developer.telematics.Model.RegisterRequest;
import com.hcl.developer.telematics.SessionManager.SessionManager;
import com.hcl.developer.telematics.Utilities.BaseActivity;
import com.hcl.developer.telematics.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity {

    ActivityRegisterBinding activityRegisterBinding;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityRegisterBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_register);
        sessionManager = new SessionManager(getApplicationContext());

        activityRegisterBinding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean validate = Validation();
                if (validate) {
                    RegisterRequest register = new RegisterRequest(activityRegisterBinding.edtFirstName.getText().toString(), activityRegisterBinding.lastName.getText().toString(), activityRegisterBinding.edtDob.getText().toString(), activityRegisterBinding.edtLicence.getText().toString(), activityRegisterBinding.edtAddress.getText().toString(), activityRegisterBinding.edtContactNumber.getText().toString(), activityRegisterBinding.edtUsername.getText().toString(), activityRegisterBinding.edtPassword.getText().toString());
                    Call<LoginResponse> call = apiService.getRegister(register);
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.body().getStatus().toString().equals("Success")) {
                                sessionManager.Login(activityRegisterBinding.edtUsername.getText().toString(), activityRegisterBinding.edtPassword.getText().toString(),"User");
                                Intent mainActivity = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(mainActivity);
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {

                        }
                    });
                }
            }
        });

    }

    public boolean Validation() {
        if (activityRegisterBinding.edtUsername.getText().length() == 0 || activityRegisterBinding.edtPassword.getText().length() == 0) {
            if (activityRegisterBinding.edtUsername.getText().length() == 0) {
                activityRegisterBinding.edtUsername.setError("Enter your Username");
            } else {
                activityRegisterBinding.edtPassword.setError("Enter your password");
            }
            return false;
        } else {
            return true;
        }
    }
}