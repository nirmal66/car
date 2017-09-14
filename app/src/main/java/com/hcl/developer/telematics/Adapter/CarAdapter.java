package com.hcl.developer.telematics.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hcl.developer.telematics.Model.CarResponse;
import com.hcl.developer.telematics.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nirmal.ku on 9/7/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder>
{

private List<CarResponse> recentCarRequestList = new ArrayList<>();

    public CarAdapter(List<CarResponse> recentCarRequestList) {
        this.recentCarRequestList = recentCarRequestList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recent_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.username.setText("test");

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView username,time;

        public MyViewHolder(View itemView) {
            super(itemView);
            username = (TextView)itemView.findViewById(R.id.userName);
        }
    }



}
