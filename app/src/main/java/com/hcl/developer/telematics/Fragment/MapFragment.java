package com.hcl.developer.telematics.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;
import com.hcl.developer.telematics.MainActivity;
import com.hcl.developer.telematics.Model.CarRequest;
import com.hcl.developer.telematics.Model.CarResponseLocation;
import com.hcl.developer.telematics.R;
import com.hcl.developer.telematics.SessionManager.SessionManager;
import com.hcl.developer.telematics.Utilities.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapFragment extends BaseFragment {

    private FusedLocationProviderClient mFusedLocationClient;
    private Double lat, lon;
    private LatLng myLocation;
    private GoogleMap mMap;
    private MapView mapView;
    private static final int PERMISSION_REQUEST_CODE = 100;
    private SessionManager sessionManager;
    private List<CarResponseLocation> carResponse = new ArrayList<>();
    private Button myRide;

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
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            PERMISSION_REQUEST_CODE);

                } else {
                    callPlaceDetectionApi();
                }

            }
        });

        myRide = (Button)view.findViewById(R.id.txt_Submit);
        myRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).fragment(new CarDetailListFragment(),"CarDetailsList");
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
                            sendLatLon(lat, lon);
                            myLocation = new LatLng(lat, lon);
                            mMap.addMarker(new MarkerOptions().position(myLocation)
                                    .title("My Location"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, (float) 14.0));

                        }
                    }
                });
    }

    private void sendLatLon(double lat, double lon) {
        sessionManager = new SessionManager(getActivity());
        CarRequest carRequest = new CarRequest(sessionManager.getUsername(), lat, lon);
        Call<List<CarResponseLocation>> call = apiService.getCarLocation(carRequest);
        call.enqueue(new Callback<List<CarResponseLocation>>() {
            @Override
            public void onResponse(Call<List<CarResponseLocation>> call, Response<List<CarResponseLocation>> response) {
                Gson gson = new Gson();
                Log.d("test", gson.toJson(response.body()).toString());
                carResponse = response.body();
                displayMap();

            }

            @Override
            public void onFailure(Call<List<CarResponseLocation>> call, Throwable t) {

            }
        });
    }

    private void displayMap() {
        for (int i = 0; i < carResponse.size(); i++) {
            myLocation = new LatLng(carResponse.get(i).getLatitudeValue(), carResponse.get(i).getLatitudeValue());
            mMap.addMarker(new MarkerOptions().position(myLocation)
                    .title(carResponse.get(i).getcarRegistrationNumber())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.carmarker)));
        }
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
