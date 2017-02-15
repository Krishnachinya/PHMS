package com.krishnchinya.personalhealthmonitoringsystem;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by KrishnChinya on 2/12/17.
 */

public class myTextWatcher implements TextWatcher {
    View view,view1;
    TextInputLayout textInputLayout;
    Context context;

    public myTextWatcher(View view,TextInputLayout textInputLayout, Context context) {
        this.view = view;//this the text filed which needs to be checked;
        this.textInputLayout = textInputLayout;
        this.context = context;
    }

    public myTextWatcher(View view, View view1, TextInputLayout textInputLayout, Context context) {
        this.view = view;//this the text filed which needs to be checked;
        this.view1 = view1;//for password recheck
        this.textInputLayout = textInputLayout;
        this.context = context;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        switch (view.getId())
        {
            case R.id.userName:
                validateUserName();
                break;
            case R.id.password:
                validatePassword();
                break;
            case R.id.etFirstName:
            case R.id.etLastName:
                validateName();
                break;
            case R.id.etEmail:
                validateUserName();
                break;
            case R.id.etHeight:
            case R.id.etWeight:s

                validateNumber();
                break;
            case R.id.etPhone:
                validatePhone();
                break;
            case R.id.etPassword:
                validateregpassword();
                break;
            case R.id.etRePass:
                validateregrepass();
                break;
        }
    }

    public boolean validateregpassword()
    {
        String password = ((EditText)view).getText().toString().trim();
        Pattern pattern_password = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
        Matcher matcher_password = pattern_password.matcher(password);

        if(password.isEmpty() || matcher_password.find())
        {
            textInputLayout.setError(context.getString(R.string.err_regpass));
            ((EditText)view).requestFocus();
            return false;
        }else{
            textInputLayout.setErrorEnabled(false);
        }
        return true;

    }

    public boolean validateregrepass()
    {
        String repassword = ((EditText)view1).getText().toString().trim();
        String password = ((EditText)view).getText().toString().trim();

        if(!password.equals(repassword))
        {
            textInputLayout.setError("Password don't match");
            ((EditText)view).requestFocus();
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;

    }


    public boolean validatePhone(){
        String number = ((EditText)view).getText().toString().trim();
        if(number.isEmpty() || !TextUtils.isDigitsOnly(number))
        {
            textInputLayout.setError("Cannot be Empty/or have characters");
            ((EditText)view).requestFocus();
            return false;
        }else{
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean validateNumber()
    {
        String number = ((EditText)view).getText().toString().trim();
        if(number.isEmpty() || !TextUtils.isDigitsOnly(number))
        {
            textInputLayout.setError("Cannot be Empty/or have characters");
            ((EditText)view).requestFocus();
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean validateName(){
        String name = ((EditText)view).getText().toString().trim();

        if(name.isEmpty())
        {
            textInputLayout.setError("Cannot be Empty/Contain digits");
            requestFocus(((EditText)view),context);
            return false;
        }
        else
        {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean validateUserName(){
        String usrname = ((EditText)view).getText().toString().trim();

        if(usrname.isEmpty() || !isValid(usrname))
        {
            textInputLayout.setError(context.getString(R.string.err_msg_email));
            requestFocus(((EditText)view),context);
            return false;
        }else
        {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean validatePassword(){
        String passwrd = ((EditText)view).getText().toString().trim();



        if (passwrd.isEmpty())
        {
            textInputLayout.setError(context.getString(R.string.err_msg_password));
            requestFocus(((EditText)view),context);
            return false;
        }else
        {
            textInputLayout.setErrorEnabled(false);
        }
        return true;

    }

    private boolean isValid(String email){
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view,Context context)
    {
        if (view.requestFocus()) {
            ((Activity)context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
