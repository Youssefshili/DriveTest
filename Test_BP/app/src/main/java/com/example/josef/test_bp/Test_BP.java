package com.example.josef.test_bp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.os.Handler;
import android.os.Message;


public class Test_BP extends AppCompatActivity {

ProgressBar bar;
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            bar.incrementProgressBy(5);

        }
    };
    boolean isRunning = false;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_test__bp);

        bar = (ProgressBar) findViewById(R.id.progressBar);
    }
    public void onStart() {
        super.onStart();
        bar.setProgress(0);
        Thread background = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 20 && isRunning; i++) {
                        Thread.sleep(1000);
                        handler.sendMessage(handler.obtainMessage());

                    }
                } catch (Throwable t) {
                }
            }
        });
        isRunning = true;

        background.start();
    }
    public void onStop() {
        super.onStop();

        isRunning = false;
    }
}

