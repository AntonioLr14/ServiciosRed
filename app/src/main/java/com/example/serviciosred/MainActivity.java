package com.example.serviciosred;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity  implements OnMapReadyCallback, RadioGroup.OnCheckedChangeListener, GoogleMap.OnMapClickListener{

    private GoogleMap mapa;
    private MapFragment mapFragment;
    private RadioGroup rgTipoMapa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ***** Ligamos los recursos de la actividad *****
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        rgTipoMapa = (RadioGroup) findViewById(R.id.rgTipoMapa);
        // ************************************************

        mapFragment.getMapAsync(this);
        rgTipoMapa.setOnCheckedChangeListener(this);
    }

    @Override
    public void onMapReady(GoogleMap map)
    {
        mapa = map;
        mapa.setOnMapClickListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        if (radioGroup.getId() == R.id.rgTipoMapa) {
            if (checkedId == R.id.rbNormal) {
                mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            } else if (checkedId == R.id.rbSatelite) {
                mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            } else if (checkedId == R.id.rbHibrido) {
                mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            } else if (checkedId == R.id.rbTopografico) {
                mapa.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        }
    }


    @Override
    public void onMapClick(LatLng latLng) {

    }

}