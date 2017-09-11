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
import com.hcl.developer.telematics.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding activityMainBinding;
    private SessionManager sessionManager;
    private String userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_login);

        sessionManager = new SessionManager(getApplicationContext());

        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.CheckLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        activityMainBinding.user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = activityMainBinding.user.getText().toString();
            }
        });

        activityMainBinding.owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = activityMainBinding.owner.getText().toString();
            }
        });

        activityMainBinding.imgSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean validate = Validation();
                if (validate) {
                    Login login = new Login(activityMainBinding.username.getText().toString(), activityMainBinding.password.getText().toString(), "admin");
                    Call<LoginResponse> call = apiService.getLogin(login);
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            //Log.d("test", response.body().getStatus().toString());
                            if (response.body() != null) {
                                if (response.body().getStatus().toString().equals("Success")) {
                                    sessionManager.Login(activityMainBinding.username.getText().toString(), activityMainBinding.password.getText().toString(),userInfo);
                                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                                    Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                                    mainActivity.putExtra("userInfo",userInfo);
                                    startActivity(mainActivity);
                                    finish();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "Invalid User name", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {

                        }
                    });

                }
            }
        });

        activityMainBinding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerActivity);
                finish();
            }
        });

        activityMainBinding.txtForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotActivity = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(forgotActivity);
                finish();
            }
        });

    }


    public boolean Validation() {
        if (activityMainBinding.username.getText().length() == 0 || activityMainBinding.password.getText().length() == 0) {
            if (activityMainBinding.username.getText().length() == 0) {
                activityMainBinding.username.setError("Enter valid email");
            } else {
                activityMainBinding.password.setError("Enter your password");
            }
            return false;
        } else {
            return true;
        }
    }


}
