package com.example.opilane.mapsgoogle;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //google play services error handler
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ServicesOK()){
            käivita();
        }
    }private void käivita(){
        Button kaart = findViewById(R.id.btnKaart);
        kaart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaataKaarti= new Intent(MainActivity.this, MapActivity.class );
                startActivity(vaataKaarti);
            }
        });


}
    public boolean ServicesOK(){
        Log.d(TAG, "ServicesOK: kontrollime google services versiooni");
        int õigeVersioon = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if (õigeVersioon == ConnectionResult.SUCCESS){
            Log.d(TAG, "ServiceOK: Google Play Services töötab");
            return true;
        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(õigeVersioon)){
            Log.d(TAG, "ServicesOK: esines viga.....");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, õigeVersioon, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else {
            Toast.makeText(this, "Kaardi päringute tegemine pole võimalik", Toast.LENGTH_SHORT).show();
        }
        return false;

    }
}

