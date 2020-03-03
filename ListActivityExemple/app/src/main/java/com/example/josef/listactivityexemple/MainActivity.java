package com.example.josef.listactivityexemple;

import android.app.ListActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends  ListActivity  {
    private String [] android_version = {"cupcake","Donut","Eclair","Froyo","Gingerbread","HoneyComb","Ice Cream sandiwish","Jelly Bean","Lollipop"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,android_version);
    setListAdapter(adapter);
    } }
