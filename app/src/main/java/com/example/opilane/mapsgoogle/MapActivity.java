package com.example.opilane.mapsgoogle;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;

import java.util.IllegalFormatCodePointException;

public class MapActivity extends AppCompatActivity {
    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION= Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION= Manifest.permission.ACCESS_COARSE_LOCATION;

    private Boolean LocationPermissionsGranted= false;

    private static final int LOCATION_PERMISSIONS_REQUEST_CODE = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    private void getLocationPermission(){
        String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            if ((ContextCompat.checkSelfPermission(this.getApplicationContext(), COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED)){
                LocationPermissionsGranted= true;
            } else {
                ActivityCompat.requestPermissions(this, permission,LOCATION_PERMISSIONS_REQUEST_CODE);

            }
        } else {
            ActivityCompat.requestPermissions(this,permission, LOCATION_PERMISSIONS_REQUEST_CODE);
        }
    }
}
