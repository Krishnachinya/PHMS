package com.krishnchinya.personalhealthmonitoringsystem.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.krishnchinya.personalhealthmonitoringsystem.activity.DB_Handler;
import com.krishnchinya.personalhealthmonitoringsystem.activity.VitalSigns;

import com.krishnchinya.personalhealthmonitoringsystem.R;
import com.krishnchinya.personalhealthmonitoringsystem.activity.Addmedication;
import com.krishnchinya.personalhealthmonitoringsystem.activity.Registration;
import com.krishnchinya.personalhealthmonitoringsystem.other.GlobalVars;


public class MainMenu_Vitals extends Fragment {
    View view;
    FloatingActionButton addVitals;
    GlobalVars globalVars;
    EditText etbtype, bmi,etglucose,etchols,etbtype1, bmi1,etglucose1,etchols1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_menu_vitals, container, false);

        globalVars = (GlobalVars) getActivity().getApplicationContext();

        addVitals = (FloatingActionButton) view.findViewById(R.id.addVitals);

        etbtype = (EditText) view.findViewById(R.id.etbtype);
        bmi = (EditText) view.findViewById(R.id.bmi);
        etglucose = (EditText) view.findViewById(R.id.etglucose);
        etchols = (EditText) view.findViewById(R.id.etchols);
        etbtype1 = (EditText) view.findViewById(R.id.etbtype1);
        bmi1 = (EditText) view.findViewById(R.id.bmi1);
        etglucose1 = (EditText) view.findViewById(R.id.etglucose1);
        etchols1 = (EditText) view.findViewById(R.id.etchols1);

        addVitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),VitalSigns.class);
                startActivityForResult(intent,1);
            }
        });

        DB_Handler db_handler = new DB_Handler(getContext());

        String[] details = db_handler.getVitalDetails(globalVars.getMailid());

        etbtype.setText(details[0]);
        bmi.setText(details[5]);
        etchols.setText(details[1]);
        etglucose.setText(details[3]);

        etbtype1.setText(details[0]);
        bmi1.setText(details[5]);
        etchols1.setText(details[1]);
        etglucose1.setText(details[3]);


        return view;
    }
}
