package com.krishnchinya.personalhealthmonitoringsystem.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krishnchinya.personalhealthmonitoringsystem.R;


public class MainMenu_Medication extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_menu_medication, container, false);
        return view;
    }
}
