package com.example.josef.premiereapplication;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PremiereActivite extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText("Bonjour, premier test");
        setContentView(text);
    }
}