package com.muhammadalfiqh.tempatmakan10119102.view.profile;
/*
    nim                 : 10119102
    nama                : Muhammad Alfiqh Nugraha
    kelas               : IF-3
*/
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muhammadalfiqh.tempatmakan10119102.R;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}