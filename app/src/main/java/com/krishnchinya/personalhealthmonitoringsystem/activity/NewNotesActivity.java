package com.krishnchinya.personalhealthmonitoringsystem.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


import com.krishnchinya.personalhealthmonitoringsystem.R;

public class NewNotesActivity extends AppCompatActivity {

    DB_Setter_Getter db_setter_getter;
    DB_Handler db_handler;

    String noteid;
    String[] notedetails;
    EditText title;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);

        title = (EditText) findViewById(R.id.etTitle);
        description = (EditText) findViewById(R.id.etDescription);
        db_handler = new DB_Handler(NewNotesActivity.this);


        String calling_activity = getIntent().getStringExtra("caller");
        if(!calling_activity.equals("newNote")){

            noteid = getIntent().getStringExtra("caller");

            notedetails = db_handler.getNote(db_setter_getter, noteid);
            title.setText(notedetails[0]);
            description.setText(notedetails[1]);
        }else
        {


        }

    }

    @Override
    public void onBackPressed(){
        db_handler = new DB_Handler(NewNotesActivity.this);

        if(title.getText().toString().isEmpty())
        {
            Toast t = Toast.makeText(NewNotesActivity.this,"Please Enter the Title",Toast.LENGTH_SHORT);
            t.show();
            return;
        }

        String calling_activity = getIntent().getStringExtra("caller");
        if(calling_activity.equals("newNote")) {

            //to get new noteid
            int count = db_handler.getNotesCount();
            count = count + 1;
            //String notecount = ""+count;

            //get title, decription and noteid
            db_setter_getter = new DB_Setter_Getter(String.valueOf(count),"krishna@gmail.com",title.getText().toString(),
                    description.getText().toString(),"");

            //save to db
            db_handler.addNotes(db_setter_getter);
            finish();

        }
        else {
            db_setter_getter = new DB_Setter_Getter("","");
            //get updated title and description
            db_setter_getter.setNotename(title.getText().toString());
            db_setter_getter.setDescription(description.getText().toString());

            //update the db
            db_handler.updateNote(db_setter_getter, calling_activity);
            finish();

        }
    }


}
