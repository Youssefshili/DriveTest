package com.example.josef.tp3;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.CheckBox;
import android.widget.CompoundButton ;
import android.widget.ToggleButton ;

import static android.R.attr.checked;



public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText login;
        final Button b1;
        RadioGroup radioGroup;
        final Button b2;
        final ToggleButton tb;
        login = (EditText) findViewById(R.id.login);
        b1=(Button) findViewById(R.id.b1);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);

        radioGroup.setOnCheckedChangeListener(this);


        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast msg = Toast.makeText(getBaseContext(), login.getText().toString(), Toast.LENGTH_LONG);
                msg.show();
            }

        });
                b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener( new OnClickListener () {
            @Override
            public void onClick(View v)
            {
                CheckBox cb, cb1 ;
                cb = (CheckBox) findViewById(R.id.checkBox);
                cb1 = (CheckBox) findViewById(R.id.checkBox2);
                if (cb.isChecked())
                {
                    Toast msg = Toast.makeText(getBaseContext(),"la case Linux est cochée", Toast.LENGTH_SHORT);
                            msg.show();
                }
                else
                if (cb1.isChecked())
                {
                    Toast msg = Toast.makeText(getBaseContext(),"la case Windows est cochée", Toast.LENGTH_SHORT);
                            msg.show();
                }
            }


        });
                tb= (ToggleButton) findViewById(R.id.toggleButton);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean
                    isChecked) {
                if (isChecked) {
                    Toast msg = Toast.makeText(getBaseContext(),"Toggle Button is checked",Toast.LENGTH_SHORT);
                            msg.show();

                }
            }});



        }

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio0:
                        Toast msg = Toast.makeText(getBaseContext(),"Radio Button rouge is checked", Toast.LENGTH_SHORT);
                                msg.show();
                        break;
                    case R.id.radio1:
                        Toast msg1 = Toast.makeText(getBaseContext(),"Radio Button vert is checked", Toast.LENGTH_SHORT);
                                msg1.show();
                        break;
                    case R.id.radio2:
                        Toast msg2 = Toast.makeText(getBaseContext(),"Radio Button bleu is checked",Toast.LENGTH_SHORT);
                                msg2.show();
                        break;
                }}

        }

