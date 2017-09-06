package com.hcl.developer.telematics.Fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.Utilities.BaseFragment;

public class MapFragment extends BaseFragment {

    private FusedLocationProviderClient mFusedLocationClient;
    private Double lat, lon;
    private LatLng myLocation;
    private GoogleMap mMap;
    private MapView mapView;

    //AIzaSyAOq1JmfkBU6iOB2Uy147lfBvR_cxOTuwc
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //fused location service will help to get the last known loaction
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());

        //https://stackoverflow.com/a/19354359/1835764
        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        mapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap Map) {
                mMap = Map;

                callPlaceDetectionApi();

            }
        });

    }

    private void callPlaceDetectionApi() throws SecurityException {
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            lat = location.getLatitude();
                            lon = location.getLongitude();

                            myLocation = new LatLng(lat, lon);
                            mMap.addMarker(new MarkerOptions().position(myLocation)
                                    .title("My Location"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, (float) 14.0));

                        }
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


}
