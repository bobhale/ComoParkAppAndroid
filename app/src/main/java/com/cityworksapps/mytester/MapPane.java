package com.cityworksapps.mytester;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.SupportMapFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;



public class MapPane extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Log.e("Tag your it", "Who nose");
       // FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
       if (mapFragment == null) Log.e("Tag your it", "Null fragment man");
        //Log.e("Tag your it", "Who nose");
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {

        Log.e("inthecallback", "Here we go ");
        LatLng stpaul = new LatLng(45.0000, -93.1333);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(stpaul, 13));

        map.addMarker(new MarkerOptions()
                .title("Saint Paul")
                .snippet("The coolest city in Minnesota.")
                .position(stpaul));
    }
}