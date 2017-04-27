package com.krishnchinya.personalhealthmonitoringsystem.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krishnchinya.personalhealthmonitoringsystem.R;
import com.krishnchinya.personalhealthmonitoringsystem.activity.DietActivity;
import com.krishnchinya.personalhealthmonitoringsystem.activity.DietSearch;
import com.krishnchinya.personalhealthmonitoringsystem.activity.VitalSigns;


public class MainMenu_Diet extends Fragment {
    View view;
    FloatingActionButton addDiet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_menu_diet, container, false);

        addDiet = (FloatingActionButton) view.findViewById(R.id.addDiet);

        addDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DietSearch.class);
                startActivityForResult(intent,1);
            }
        });

        return view;
    }
}
