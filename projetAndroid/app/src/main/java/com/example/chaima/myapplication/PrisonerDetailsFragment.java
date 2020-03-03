package com.example.chaima.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class PrisonerDetailsFragment extends Activity implements View.OnClickListener {

    private ImageView thumbnail;
    private TextView tvName;
    private TextView tvMatricule;
    private TextView tvAddress;
    private EditText etNotes;
    private Button btnSave;
    private  SharedPreferences.Editor editor;
    private  SharedPreferences pref;
    Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_prisoner_details);





        String name=getIntent().getStringExtra("name");
        String address=getIntent().getStringExtra("address");
        String matricule=getIntent().getStringExtra("matricule");
        Integer smallPictureId=getIntent().getIntExtra("smallPictureId",0);
        id=getIntent().getIntExtra("",0);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
       String note= pref.getString(id.toString(), "none"); // getting String





        thumbnail=(ImageView)findViewById(R.id.thumbnail);
        tvName=(TextView)findViewById(R.id.tvName);
        tvMatricule=(TextView)findViewById(R.id.tvMatricule);

        tvAddress=(TextView)findViewById(R.id.tvAddress);
        etNotes=(EditText)findViewById(R.id.etNotes);
        etNotes.setText(note);
        btnSave=(Button)findViewById(R.id.btnSave);


        tvName.setText(name);
        tvMatricule.setText(address);
        tvAddress.setText(matricule);

        btnSave.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        editor.putString(id.toString(), etNotes.getText().toString()); // Storing integer

        editor.commit(); // commit changes
        Toast.makeText(this,"succes",Toast.LENGTH_LONG).show();
        Intent vers_Main_ac=new Intent(this,MainActivity.class);
        startActivity(vers_Main_ac);


    }


//
//    }
}
