package com.hcl.developer.telematics.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.Utilities.BaseFragment;

public class AddNewCarFragment extends BaseFragment {



    //AIzaSyAOq1JmfkBU6iOB2Uy147lfBvR_cxOTuwc
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_new_car, container, false);
    }
}
