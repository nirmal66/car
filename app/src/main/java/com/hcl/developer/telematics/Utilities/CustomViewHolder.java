package com.hcl.developer.telematics.Utilities;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * Created by nirmal.ku on 9/14/2017.
 */

public class CustomViewHolder extends ViewHolder {


    private ViewDataBinding mViewDataBinding;
    public CustomViewHolder(ViewDataBinding viewDataBinding) {

        super(viewDataBinding.getRoot());

        mViewDataBinding = viewDataBinding;
        mViewDataBinding.executePendingBindings();
    }

    public ViewDataBinding getViewDataBinding() {
        return mViewDataBinding;
    }
}
