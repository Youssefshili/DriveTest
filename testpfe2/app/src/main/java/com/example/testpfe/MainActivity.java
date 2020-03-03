package com.example.testpfe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.info);
    }

    public void onSubmit(View v) {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        int callstate = tm.getCallState();
        String callstat ="";
        switch (callstate) {
            case TelephonyManager.CALL_STATE_IDLE:
                callstat ="Call State:Phone is idle \n";
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                callstat ="Call State:Phone is in use\n";
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                callstat ="Call State:Phone is ringing\n";
                break;
        }
        String opname ="\nOperator ID:"+" "+tm.getNetworkOperator();
        opname = opname +"\nOperator Name:"+ " " +tm.getNetworkOperatorName();

        int phoneType = tm.getPhoneType();
        String ptype ="";
        switch (phoneType) {
            case TelephonyManager.PHONE_TYPE_CDMA:
                ptype ="\nPhone Type:CDMA\n";
                break;
            case TelephonyManager.PHONE_TYPE_GSM:
                ptype ="\nPhone Type:GSM\n";
                break;
            case TelephonyManager.PHONE_TYPE_SIP:
                ptype ="\nPhone Type:SIP\n";
                break;
            case TelephonyManager.PHONE_TYPE_NONE:
                ptype ="\nPhone Type:NONE\n";
                break;
        }

        boolean isRoaming = tm.isNetworkRoaming();
        String pDetails ="";
        if (isRoaming) {
            pDetails ="Roaming: Yes\n";
        } else {
            pDetails ="Roaming: No\n";
        }

        int sim = tm.getSimState();
        String sstate ="";
        switch (sim) {
            case TelephonyManager.SIM_STATE_ABSENT:
                sstate ="Sim State:Absent\n";
                break;
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                sstate ="Sim State:Network Locked\n";
                break;
            case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                sstate ="Sim State:Pin Required\n";
                break;
            case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                sstate ="Sim State:Puk Required\n";
                break;
            case TelephonyManager.SIM_STATE_READY:
                sstate ="Sim State:Ready\n";
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                sstate ="Sim State:Unknown\n";
                break;
        }
        tv.setText(callstat + opname + ptype + pDetails + sstate);
    }


}