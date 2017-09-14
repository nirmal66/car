package com.hcl.developer.telematics.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.hcl.developer.telematics.Adapter.CarAdapter;
import com.hcl.developer.telematics.Model.CarRequest;
import com.hcl.developer.telematics.Model.CarResponse;
import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.SessionManager.SessionManager;
import com.hcl.developer.telematics.Utilities.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarDetailListFragment extends BaseFragment
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SessionManager sessionManager;
    private List<CarResponse> carResponse = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_carlist_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preparenotificationData();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view_app);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
    private void preparenotificationData() {
        sessionManager = new SessionManager(getActivity());
        CarRequest carRequest = new CarRequest(sessionManager.getUsername(), 12.9056533, 80.2192789);
        Call<List<CarResponse>> call = apiService.getCarList(carRequest);
        call.enqueue(new Callback<List<CarResponse>>() {
            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                Gson gson = new Gson();
                Log.d("test", gson.toJson(response.body()).toString());
                carResponse = response.body();
                mAdapter = new CarAdapter(carResponse);
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }


}
