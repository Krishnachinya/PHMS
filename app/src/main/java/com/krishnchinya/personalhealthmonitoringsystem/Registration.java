package com.krishnchinya.personalhealthmonitoringsystem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Locale;

/**
 * Created by KrishnChinya on 2/11/17.
 */

public class Registration extends Activity{

    EditText dob,etFirstName,etLastName,etWeight,etHeight,etPhone,etEmail,etPassword,etRePass;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormat;
    RadioButton btnMale ,btnFemale;

    Button signup;
    myTextWatcher watcher1,watcher2,watcher3,watcher4,watcher5,watcher6,watcher7,watcher8,watcher9;
    TextInputLayout input_etFirstName,input_etLastName,input_etWeight,
            input_etHeight,input_etPhone,input_etEmail,input_etpassword,input_etrepass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final DB_Handler db_handler = new DB_Handler(Registration.this);

        dob = (EditText) findViewById(R.id.etdob);
        signup = (Button) findViewById(R.id.btnSignup);
        dob.setInputType(InputType.TYPE_NULL);

        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hide the keyboard
                InputMethodManager inputManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(v.getWindowToken(),0);

                Calendar calenderinstance = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(Registration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar newdate = Calendar.getInstance();
                        newdate.set(year,month,dayOfMonth);
                        dob.setText(dateFormat.format(newdate.getTime()));

                    }
                },calenderinstance.get(Calendar.YEAR), calenderinstance.get(Calendar.MONTH),calenderinstance.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRePass = (EditText) findViewById(R.id.etRePass);
        btnMale = (RadioButton)findViewById(R.id.btnMale);
        btnFemale = (RadioButton)findViewById(R.id.btnFeale);


        input_etFirstName = (TextInputLayout) findViewById(R.id.input_etFirstName);
        input_etLastName= (TextInputLayout) findViewById(R.id.input_etLastName);
        input_etWeight= (TextInputLayout) findViewById(R.id.input_etWeight);
        input_etHeight= (TextInputLayout) findViewById(R.id.input_etHeight);
        input_etPhone= (TextInputLayout) findViewById(R.id.input_etPhone);
        input_etEmail= (TextInputLayout) findViewById(R.id.input_etEmail);
        input_etpassword= (TextInputLayout) findViewById(R.id.input_etpassword);
        input_etrepass= (TextInputLayout) findViewById(R.id.input_etrepass);

        watcher1 = new myTextWatcher(etFirstName,input_etFirstName,Registration.this);
        watcher2 = new myTextWatcher(etLastName,input_etLastName,Registration.this);
        watcher3 = new myTextWatcher(etEmail,input_etEmail,Registration.this);
        watcher4 = new myTextWatcher(etWeight,input_etWeight,Registration.this);
        watcher5 = new myTextWatcher(etHeight,input_etHeight,Registration.this);
        watcher6 = new myTextWatcher(etPhone,input_etPhone,Registration.this);
        watcher7 = new myTextWatcher(etPassword,input_etpassword,Registration.this);
        watcher8 = new myTextWatcher(etRePass,etPassword,input_etrepass,Registration.this);
       // watcher9 = new myTextWatcher(btnMale,btnFemale,Registration.this);


        etFirstName.addTextChangedListener(watcher1);
        etLastName.addTextChangedListener(watcher2);
        etEmail.addTextChangedListener(watcher3);
        etWeight.addTextChangedListener(watcher4);
        etHeight.addTextChangedListener(watcher5);
        etPhone.addTextChangedListener(watcher6);
        etPassword.addTextChangedListener(watcher7);
        etRePass.addTextChangedListener(watcher8);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!watcher1.validateName() && !watcher2.validateName()) {
                    return;
                }
                if (!watcher3.validateUserName()) {
                    return;
                }
                if(!watcher4.validateWight() && !watcher5.validateHeight() && !watcher6.validatePhone()){
                    return;
                }
                if (!watcher8.validateregrepass() && !watcher8.validateregpassword() ) {
                    return;
                }
//                if(!watcher9.validateGender())
//                {
//                    return;
//                }


                DB_Setter_Getter dbSetterGetter = new DB_Setter_Getter(etFirstName.getText().toString(),
                        etLastName.getText().toString(),dob.getText().toString(),"Male",etEmail.getText().toString(),
                        etWeight.getText().toString(),etHeight.getText().toString(),etPhone.getText().toString()
                        ,etPassword.getText().toString());

                if(db_handler.checkMail(dbSetterGetter)) {
                    db_handler.addRegistration(dbSetterGetter);
                    db_handler.addLogin(dbSetterGetter);

                    Intent intent = new Intent(Registration.this, Login_Activity.class);
                    startActivity(intent);
                }else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                    builder.setTitle("Error");
                    builder.setMessage("Duplicate Mail Id");
                    builder.show();
                }
            }
        });
    }
}
