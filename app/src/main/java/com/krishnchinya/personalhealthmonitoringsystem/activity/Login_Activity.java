package com.krishnchinya.personalhealthmonitoringsystem.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.krishnchinya.personalhealthmonitoringsystem.R;
import com.krishnchinya.personalhealthmonitoringsystem.other.GlobalVars;

/**
 * Created by KrishnChinya on 2/11/17.
 */

public class Login_Activity extends Activity {
    private TextInputLayout usernameInputLayout, passwordInputLayout;
    private Button loginButton, newUser, forgotPass;
    private EditText usernameEditText, passwordEditText;
    myTextWatcher watcher1, watcher2;
    GlobalVars globalVars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getActionBar().hide();
        final AlertDialog.Builder builder = new AlertDialog.Builder(Login_Activity.this);

        usernameInputLayout = (TextInputLayout) findViewById(R.id.input_username);
        passwordInputLayout = (TextInputLayout) findViewById(R.id.input_password);

        usernameEditText = (EditText) findViewById(R.id.userName);
        passwordEditText = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.login);
        newUser = (Button) findViewById(R.id.NewUser);
        forgotPass = (Button) findViewById(R.id.forgotPass);

        watcher1 = new myTextWatcher(usernameEditText,usernameInputLayout, Login_Activity.this);
        watcher2 = new myTextWatcher(passwordEditText,passwordInputLayout,Login_Activity.this);

        usernameEditText.addTextChangedListener(watcher1);
        passwordEditText.addTextChangedListener(watcher2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!watcher1.validateUserName()) {
                    return;
                }
                if (!watcher2.validatePassword()) {
                    return;
                }

                DB_Setter_Getter dbSetterGetter = new DB_Setter_Getter(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
                DB_Handler db_handler = new DB_Handler(Login_Activity.this);
                String[] details = db_handler.getcredentials(dbSetterGetter);

                if(details[0].equals(dbSetterGetter.getMailID()) && details[1].equals(dbSetterGetter.getPassword()))
                {
                    //set the global variables for further use.
                    globalVars = (GlobalVars) getApplicationContext();
                    globalVars.setUsername(details[2].toString());
                    globalVars.setMailid(details[0].toString());

                    Intent intent = new Intent(Login_Activity.this, MainMenu.class);
                    startActivityForResult(intent,1);
                }else
                {
                    builder.setTitle("");
                    builder.setMessage("Wrong Username/Password");
                    builder.show();
                }

            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this ,Registration.class);
                startActivityForResult(intent,1);
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, ForgotPassword.class);
                startActivityForResult(intent,1);
            }
        });


    }




}
