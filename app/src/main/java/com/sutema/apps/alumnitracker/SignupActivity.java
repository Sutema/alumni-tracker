package com.sutema.apps.alumnitracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText) findViewById(R.id.editText8);
        email = (EditText) findViewById(R.id.editText9);
        password = (EditText) findViewById(R.id.editText10);
        confirmpassword = (EditText) findViewById(R.id.editText11);
    }

    public void SignUp (View view) {

    }

    }