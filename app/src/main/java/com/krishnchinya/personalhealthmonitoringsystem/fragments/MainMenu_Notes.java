package com.krishnchinya.personalhealthmonitoringsystem.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.krishnchinya.personalhealthmonitoringsystem.R;
import com.krishnchinya.personalhealthmonitoringsystem.activity.DB_Handler;
import com.krishnchinya.personalhealthmonitoringsystem.activity.DB_Setter_Getter;
import com.krishnchinya.personalhealthmonitoringsystem.activity.NewNotesActivity;

import java.util.ArrayList;


public class MainMenu_Notes extends Fragment {
    View view;

    private RecyclerView notesRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;

    private DB_Setter_Getter db_setter_getter;

    private DB_Handler db_handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_menu_notes, container, false);


        notesRecyclerView = (RecyclerView) view.findViewById(R.id.notes_recycler_view);

        notesRecyclerView.setHasFixedSize(true);

        // mLayoutManager=new LinearLayoutManager();
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL,false));

        db_handler = new DB_Handler(getContext());

        ArrayList<String> details = db_handler.getAllNotes("krishna@gmail.com");

        myNotesAdapter adapter = new myNotesAdapter(details);
        notesRecyclerView.setAdapter(adapter);


        FloatingActionButton newNote = (FloatingActionButton) view.findViewById(R.id.newNote);
        newNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getContext(), NewNotesActivity.class);
                intent.putExtra("caller", "newNote");
                startActivityForResult(intent,1);
            }

        });

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }
}

class myNotesAdapter extends RecyclerView.Adapter<notesViewholder>
{
    private ArrayList<String> myData;
    private String[] Id;
    int count=0;

    public myNotesAdapter(ArrayList<String> mData){
        myData=mData;
       // this.Id = Id;
    }

    @Override
    public notesViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_veiw_notes,parent,false);

        notesViewholder vh =new notesViewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final notesViewholder holder, final int position) {
        holder.notesName.setText(myData.get(count++));
        holder.noteid.setText(myData.get(count++));

        holder.notesName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewNotesActivity.class);
                intent.putExtra("caller", holder.noteid.getText().toString());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myData.size()/2;
    }
}

class notesViewholder extends RecyclerView.ViewHolder{
    TextView notesName,noteid;
    public notesViewholder(View itemView) {
        super(itemView);
        notesName = (TextView) itemView.findViewById(R.id.tvNotesName);
        noteid = (TextView) itemView.findViewById(R.id.noteid);
    }
}