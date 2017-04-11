package com.krishnchinya.personalhealthmonitoringsystem.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.krishnchinya.personalhealthmonitoringsystem.R;

public class NotesActivity extends AppCompatActivity {

    private RecyclerView notesRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notesRecyclerView = (RecyclerView) findViewById(R.id.notes_recycler_view);

        notesRecyclerView.setHasFixedSize(true);

       // mLayoutManager=new LinearLayoutManager();
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayout.VERTICAL,false));

        myNotesAdapter adapter = new myNotesAdapter(new String[]{"test1","test2","test3","test44"});
        notesRecyclerView.setAdapter(adapter);

    }
}


class myNotesAdapter extends RecyclerView.Adapter<notesViewholder>
{
    private String[] myData;

    public myNotesAdapter(String[] mData){
            myData=mData;
    }

    @Override
    public notesViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_veiw_notes,parent,false);

        notesViewholder vh =new notesViewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(notesViewholder holder, int position) {
        holder.notesName.setText(myData[position]);

    }

    @Override
    public int getItemCount() {
        return myData.length;
    }
}

class notesViewholder extends RecyclerView.ViewHolder{
    TextView notesName;
    public notesViewholder(View itemView) {
        super(itemView);
        notesName = (TextView) itemView.findViewById(R.id.tvNotesName);
    }
}