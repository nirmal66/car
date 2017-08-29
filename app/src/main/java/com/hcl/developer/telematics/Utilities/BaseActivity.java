package com.hcl.developer.telematics.Utilities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hcl.developer.telematics.RetroGit.ApiClient;
import com.hcl.developer.telematics.RetroGit.ApiInterface;

/**
 * Created by nirmal.ku on 8/29/2017.
 */

public class BaseActivity extends Activity {

    protected ApiInterface apiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }
}
