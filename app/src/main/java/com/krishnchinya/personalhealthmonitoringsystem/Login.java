package com.krishnchinya.personalhealthmonitoringsystem;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity {

    private TextInputLayout usernameInputLayout, passwordInputLayout;
    private Button loginButton;
    private EditText usernameEditText, passwordEditText;
    private View mContentView;

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();

    //need 2 runnables/threads to hide the control view when application is launched

    private Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {

            //// Delayed removal of status and navigation bar
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    } ;

    private View mControlsView;

    private Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };

    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mContentView = findViewById(R.id.logo);
        mControlsView = findViewById(R.id.logo);

        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toggle();
            }
        });


        usernameInputLayout = (TextInputLayout) findViewById(R.id.input_username);
        passwordInputLayout = (TextInputLayout) findViewById(R.id.input_password);

        usernameEditText = (EditText) findViewById(R.id.userName);
        passwordEditText = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.login);

        usernameEditText.addTextChangedListener(new myTextWatcher(usernameEditText));
        passwordEditText.addTextChangedListener(new myTextWatcher(passwordEditText));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUserName()) {
                    return;
                }
                if (!validatePassword()) {
                    return;
                }
            }
        });


    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        delayedHide(100);

    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            //show();
        }
    }

    private void hide(){
        ActionBar actionBar = getActionBar();
        //we are checking if action bar is hidden or not? if not then hide it.
        if(actionBar != null)
        {
            actionBar.hide();
        }

        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);

    }

    private void show(){
    // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }


    private boolean validateUserName(){
        String usrname = usernameEditText.getText().toString().trim();

        if(usrname.isEmpty() || !isValid(usrname))
        {
            usernameInputLayout.setError(getString(R.string.err_msg_email));
            requestFocus(usernameEditText);
            return false;
        }else
        {
            usernameInputLayout.setErrorEnabled(false);
        }
        hide();
        return true;
    }

    private boolean validatePassword(){
        String passwrd = passwordEditText.getText().toString().trim();

        if (passwrd.isEmpty())
        {
            passwordInputLayout.setError(getString(R.string.err_msg_password));
            requestFocus(passwordEditText);
            return false;
        }else
        {
            passwordInputLayout.setErrorEnabled(false);
        }
        hide();
        return false;

    }

    private boolean isValid(String email){
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view)
    {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


    public class myTextWatcher implements TextWatcher {

            View view;

            public myTextWatcher(View view) {
                this.view = view;
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
                }
            }

    }


}
