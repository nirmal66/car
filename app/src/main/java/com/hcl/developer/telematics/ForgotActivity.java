package com.hcl.developer.telematics;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hcl.developer.telematics.Model.Login;
import com.hcl.developer.telematics.Model.LoginResponse;
import com.hcl.developer.telematics.SessionManager.SessionManager;
import com.hcl.developer.telematics.Utilities.BaseActivity;
import com.hcl.developer.telematics.databinding.ActivityForgetPasswordBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotActivity extends BaseActivity {

    ActivityForgetPasswordBinding activityForgotPasswordBinding;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityForgotPasswordBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_forget_password);
        sessionManager = new SessionManager(getApplicationContext());

        activityForgotPasswordBinding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean validate = Validation();
                if (validate) {
                    Login login = new Login(activityForgotPasswordBinding.edtUsername.getText().toString(), activityForgotPasswordBinding.edtConfirmPassword.getText().toString(), "admin");
                    Call<LoginResponse> call = apiService.getReset(login);
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            //Log.d("test", response.body().getStatus().toString());
                            if (response.body() != null) {

                                if (response.body().getStatus().toString().equals("Success")) {
                                    sessionManager.Login(activityForgotPasswordBinding.edtUsername.getText().toString(), activityForgotPasswordBinding.edtConfirmPassword.getText().toString(),"User");
                                    Toast.makeText(ForgotActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                                    Intent mainActivity = new Intent(ForgotActivity.this, MainActivity.class);
                                    startActivity(mainActivity);
                                }
                            } else {
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
        if (activityForgotPasswordBinding.edtUsername.getText().length() == 0 || activityForgotPasswordBinding.edtConfirmPassword.getText().length() == 0) {
            if (activityForgotPasswordBinding.edtUsername.getText().length() == 0) {
                activityForgotPasswordBinding.edtUsername.setError("Enter valid email");
            } else {
                activityForgotPasswordBinding.edtConfirmPassword.setError("Enter your password");
            }
            return false;
        } else {
            return true;
        }
    }

}
