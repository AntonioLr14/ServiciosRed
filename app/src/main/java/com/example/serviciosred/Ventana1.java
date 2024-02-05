package com.example.serviciosred;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.serviciosred.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class Ventana1 extends Fragment implements OnMapReadyCallback, RadioGroup.OnCheckedChangeListener, GoogleMap.OnMapClickListener {

    private GoogleMap mapa;
    private MapFragment mapFragment;
    private RadioGroup rgTipoMapa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ventana1, container, false);

        // ***** Ligamos los recursos del fragmento *****
        mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map);
        rgTipoMapa = view.findViewById(R.id.rgTipoMapa);
        // ************************************************

        mapFragment.getMapAsync(this);
        rgTipoMapa.setOnCheckedChangeListener(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
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
        // Handle map click if needed
    }
}

