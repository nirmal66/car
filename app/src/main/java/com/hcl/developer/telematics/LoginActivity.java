package com.hcl.developer.telematics;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hcl.developer.telematics.Model.Login;
import com.hcl.developer.telematics.Model.LoginResponse;
import com.hcl.developer.telematics.Utilities.BaseActivity;
import com.hcl.developer.telematics.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityLoginBinding activityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_login);

        activityMainBinding.imgSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Login login = new Login(activityMainBinding.username.getText().toString(), activityMainBinding.password.getText().toString(), "admin");
                Call<LoginResponse> call = apiService.getLogin(login);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        //Log.d("test", response.body().getStatus().toString());
                        if (response.body() != null) {
                            if (response.body().getStatus().toString().equals("Success")) {
                                Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(mainActivity);
                            }
                        } else {
                                Toast.makeText(LoginActivity.this,"Invalid User name",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

            }
        });

        activityMainBinding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerActivity);
            }
        });

        activityMainBinding.txtForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotActivity = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(forgotActivity);
            }
        });

    }


}
