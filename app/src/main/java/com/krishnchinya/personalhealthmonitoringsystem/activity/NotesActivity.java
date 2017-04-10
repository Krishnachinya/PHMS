package com.krishnchinya.personalhealthmonitoringsystem.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.krishnchinya.personalhealthmonitoringsystem.R;

public class NotesActivity extends AppCompatActivity {


    private RecyclerView notesRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notesRecyclerView = (RecyclerView) findViewById(R.id.notes_recycler_view);

        notesRecyclerView.setHasFixedSize(true);

        mLayoutManager=new LinearLayoutManager(this);
        notesRecyclerView.setLayoutManager(mLayoutManager);



    }
}
