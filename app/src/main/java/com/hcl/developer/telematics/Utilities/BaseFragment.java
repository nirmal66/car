package com.hcl.developer.telematics.Utilities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.hcl.developer.telematics.RetroGit.ApiClient;
import com.hcl.developer.telematics.RetroGit.ApiInterface;

/**
 * Created by nirmal.ku on 8/29/2017.
 */

public class BaseFragment extends Fragment {

    protected ApiInterface apiService;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiService = ApiClient.getClient().create(ApiInterface.class);

    }


}
