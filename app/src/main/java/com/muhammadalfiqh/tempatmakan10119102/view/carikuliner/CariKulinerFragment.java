package com.muhammadalfiqh.tempatmakan10119102.view.carikuliner;
/*
    nim                 : 10119102
    nama                : Muhammad Alfiqh Nugraha
    kelas               : IF-3
*/
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.muhammadalfiqh.tempatmakan10119102.R;


public class CariKulinerFragment extends Fragment implements OnMapReadyCallback{
    private GoogleMap mMap;

    public CariKulinerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cari_kuliner, container, false);
        SupportMapFragment mMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.carikulinermap);
        mMapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Bandung and move the camera
        LatLng kuliner_cikapundung = new LatLng(-6.919831851767335, 107.60830329019089);
        LatLng saung_kuliner_sunda = new LatLng(-6.917220775731297, 107.60395610740477);
        LatLng golden_flower = new LatLng(-6.92012197043555, 107.60427270895221);
        LatLng bubur_ayam_bintang5 = new LatLng(-6.825652540533795, 107.64281883742389);
        LatLng cibadak_night_kuliner = new LatLng(-6.921536296389753, 107.6005221983132);

        mMap.addMarker(new MarkerOptions().position(kuliner_cikapundung).title("Wisata Kuliner Cikapundung"));
        mMap.addMarker(new MarkerOptions().position(saung_kuliner_sunda).title("Saung Kuliner Sunda"));
        mMap.addMarker(new MarkerOptions().position(golden_flower).title("Golden Flower"));
        mMap.addMarker(new MarkerOptions().position(bubur_ayam_bintang5).title("Bubur Ayam Bintang 5"));
        mMap.addMarker(new MarkerOptions().position(cibadak_night_kuliner).title("Cibadak Night Kuliner"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(golden_flower, 14));

    }
}