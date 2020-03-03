package com.example.chaima.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class LoginActivity extends Activity implements View.OnClickListener {

    Button btnSubmit ,sign;
    EditText etLogin, etPass;
    String login, pass;
    private  SharedPreferences.Editor editor;
    private  SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_login);
        //TODO 1 - préparer les composants de l'interface graphique
   etLogin=(EditText)findViewById(R.id.etLogin);
         etPass=(EditText)findViewById(R.id.etPass);
        ImageView image=(ImageView)findViewById(R.id.ivLogo);



         btnSubmit=(Button)findViewById(R.id.btnSubmit);
        sign=(Button)findViewById(R.id.sign);


        btnSubmit.setOnClickListener(this);
        sign.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        // TODO 2 - Vérification des Login et Password, Toast si incorrect
if(view.getId()==R.id.btnSubmit){
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String user= pref.getString("user", "none"); // getting String
        String passe= pref.getString("passe", "none"); // getting String


        if ((etLogin.getText().toString().equals(user))&&(etPass.getText().toString().equals(passe))) {
            Intent int1 = new Intent(this, MainActivity.class);
            startActivity(int1);
            Toast.makeText(this,"welcome",Toast.LENGTH_LONG).show();


        }
        else
        {
            Toast.makeText(this,"User or Password are incorrect",Toast.LENGTH_LONG).show();
        }

}
else
{
    Intent vers_register = new Intent(this, Register.class);
    pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
    editor = pref.edit();
    editor.putString("username", etLogin.getText().toString()); // Storing integer
    editor.putString("passename", etPass.getText().toString()); // Storing integer


    editor.commit(); // commit changes
    startActivity(vers_register);
    Toast.makeText(this,"Sign up",Toast.LENGTH_LONG).show();

}


    }
}

