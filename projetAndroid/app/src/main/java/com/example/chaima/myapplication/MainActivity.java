package com.example.chaima.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {
    ListView maListViewPerso;
    private  SharedPreferences.Editor editor;
    private  SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_prisoners_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView e1=(TextView)findViewById(R.id.tvTitle) ;
        ListView maListViewPerso = (ListView)findViewById(R.id.lvListPrisoners);


        maListViewPerso.setAdapter(new PrisonerAdapter(getBaseContext(), R.layout.item_prisoner_row,PrisonerContent.ITEMS ));

        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, PrisonerContent.ITEMS.get(position)+"", Toast.LENGTH_SHORT).show();
                Intent detail=new Intent(getBaseContext(),PrisonerDetailsFragment.class);
                detail.putExtra("name",PrisonerContent.ITEMS.get(position).name);
                detail.putExtra("address",PrisonerContent.ITEMS.get(position).address);
                detail.putExtra("matricule",PrisonerContent.ITEMS.get(position).matricule);
                detail.putExtra("smallPictureId",PrisonerContent.ITEMS.get(position).smallPictureId);
                detail.putExtra("id",PrisonerContent.ITEMS.get(position).id);


                startActivity(detail);





            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
        Log.e("Position",""+position);
        System.out.println("postion");

    }

    @Override
    public void onClick(View v) {



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_item:
                // do your code
                return true;
            case R.id.profile:
                pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                String username= pref.getString("user", "none"); // getting String
                String passename= pref.getString("passe", "none"); // getting String
                Toast.makeText(this, "you are connected with"+username+" " +passename+" ", Toast.LENGTH_SHORT).show();


                return true;
            case R.id.disconected:
                // do your code

                Intent ver_login=new Intent(this,LoginActivity.class);
                startActivity(ver_login);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
