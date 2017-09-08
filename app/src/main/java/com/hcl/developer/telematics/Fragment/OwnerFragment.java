package com.hcl.developer.telematics.Fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hcl.developer.telematics.Adapter.ViewPagerAdapter;
import com.hcl.developer.telematics.MainActivity;
import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.databinding.FragmentOwnerBinding;

public class OwnerFragment extends Fragment {


    private FragmentOwnerBinding binding;
    ViewPagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_owner, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager(binding.viewpager);
        binding.tabs.setupWithViewPager(binding.viewpager);
        binding.moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).fragment(new CarHealthFragment(),"Car Health Fragment");
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        adapter = new ViewPagerAdapter(getChildFragmentManager());
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new HomeOwnerFragment(), "Recent Car Request");
        adapter.addFragment(new HistoryOwnerFragment(), "History");
        viewPager.setAdapter(adapter);
    }
}
