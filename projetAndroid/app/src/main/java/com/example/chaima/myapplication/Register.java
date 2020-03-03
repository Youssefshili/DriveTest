package com.example.chaima.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity implements View.OnClickListener {
    Button btnSubmit;
    EditText etLogin, etPass;

    private  SharedPreferences.Editor editor;
    private  SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etLogin=(EditText)findViewById(R.id.etLogin);
        etPass=(EditText)findViewById(R.id.etPass);
        btnSubmit=(Button)findViewById(R.id.inscrir);

        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        editor.putString("user", etLogin.getText().toString()); // Storing integer
        editor.putString("passe", etPass.getText().toString()); // Storing integer


        editor.commit(); // commit changes
        Intent ver_login = new Intent(this, LoginActivity.class);
        startActivity(ver_login);


    }
}
