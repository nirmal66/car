package com.hcl.developer.telematics.Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hcl.developer.telematics.MainActivity;
import com.hcl.developer.telematics.Model.CarRegister;
import com.hcl.developer.telematics.Model.LoginResponse;
import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.SessionManager.SessionManager;
import com.hcl.developer.telematics.Utilities.BaseFragment;
import com.hcl.developer.telematics.databinding.FragmentAddNewCarBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewCarFragment extends BaseFragment {


    private FragmentAddNewCarBinding binding;
    private SessionManager sessionManager;
    private String carType;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_new_car, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sessionManager = new SessionManager(getActivity());


        binding.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carType = binding.radioButton.getText().toString();
            }
        });
        binding.radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carType = binding.radioButton2.getText().toString();
            }
        });
        binding.radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carType = binding.radioButton3.getText().toString();
            }
        });
        binding.txtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarRegister carRegister = new CarRegister(sessionManager.getUsername().toString(),binding.edtCarRegNo.getText().toString(),binding.edtLastServiceDate.getText().toString(),binding.edtFarePerMile.getText().toString(),carType);
                Call<LoginResponse> call = apiService.getCarRegister(carRegister);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.body() != null) {
                            if (response.body().getStatus().toString().equals("Success")) {
                                Toast.makeText(getActivity(), "Success", Toast.LENGTH_LONG).show();
                                ((MainActivity)getActivity()).fragment(new OwnerFragment(),"OwnerFragment");

                            }
                        } else {
                            Toast.makeText(getActivity(), "Status Failed", Toast.LENGTH_LONG).show();
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
