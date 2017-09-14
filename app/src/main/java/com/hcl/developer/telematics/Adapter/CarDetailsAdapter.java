package com.hcl.developer.telematics.Adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hcl.developer.telematics.Model.CarResponse;
import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.Utilities.CustomViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nirmal.ku on 9/7/2017.
 */

public class CarDetailsAdapter extends RecyclerView.Adapter<CustomViewHolder>
{

    private List<CarResponse> recentCarRequestList = new ArrayList<>();

    public CarDetailsAdapter(List<CarResponse> recentCarRequestList) {
        this.recentCarRequestList = recentCarRequestList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.history_list_row, viewGroup, false);
        return new CustomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        viewDataBinding.setVariable(BR.car, recentCarRequestList.get(position));
    }

    @Override
    public int getItemCount() {
        return (null != recentCarRequestList ? recentCarRequestList.size() : 0);
    }





}