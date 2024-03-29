package com.example.serviciosred;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class Ventana3 extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private MapFragment mapFragment;
    private GoogleMap googleMap;

    public Ventana3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ventana3, container, false);

        // ***** Ligamos los recursos del fragmento *****
        mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map3);
        // ************************************************

        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        googleMap.setOnMapClickListener(this);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        // Mostrar un mensaje en un Toast con las coordenadas al hacer clic en la ubicación
        String message = "Ubicación seleccionada: Latitud " + latLng.latitude + ", Longitud " + latLng.longitude;
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

    }


}

