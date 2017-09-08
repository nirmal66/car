package com.hcl.developer.telematics.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hcl.developer.telematics.MainActivity;
import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.Utilities.BaseFragment;

public class CarHealthFragment extends BaseFragment {


    Button addNewcar;

    //AIzaSyAOq1JmfkBU6iOB2Uy147lfBvR_cxOTuwc
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_details, container, false);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addNewcar = (Button)view.findViewById(R.id.btn_add_newcar);
        addNewcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).fragment(new AddNewCarFragment(),"Add New Car Fragment");
            }
        });
    }
}
