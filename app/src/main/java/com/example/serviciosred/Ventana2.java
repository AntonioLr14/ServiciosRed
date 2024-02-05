package com.example.serviciosred;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.serviciosred.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Ventana2 extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mapa;
    private MapFragment mapFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ventana2, container, false);

        // ***** Ligamos los recursos del fragmento *****
        mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map2);
        // ************************************************

        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapa = map;
        mapa.setOnMapClickListener(this);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        insertarMarcador(latLng);
    }

    /**
     * Inserta un marcador en un Google Maps
     * @param coordenadas Coordenadas para insertar dicho marcador
     */
    private void insertarMarcador(LatLng coordenadas) {
        mapa.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("Marcador"));
    }
}


