package com.example.josef.tp4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class MainActivity extends ActionBarActivity implements
        AdapterView.OnItemSelectedListener {
    // declaration des variables de la classe
    TextView Selection;
    String[] item={"Tunisie","France","Italie","Canada","Amerique"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // création de l’activité et affectation du Layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // récupération des identificateurs des widgets TextView et Spinner pour leur
        //traitement et affectation des écouteurs
        Selection = (TextView) findViewById(R.id.textView1);
        Spinner Spin = (Spinner) findViewById(R.id.spinner1);
        Spin.setOnItemSelectedListener(this);
        // création de l’adaptateur ArrayAdapter dont les éléments de son tableau
        //sont de type chaine de caractères à prendre à partir du variable item
        //pour remplier les items du spinner se trouvant dans le layout.
//Contexte d’affichage
        ArrayAdapter<String> aa= new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item,item);

        //Remplissage des différents éléments du spinner de la vue par les éléments du
        //la variable item
        aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // affectation de l’adaptateur au spinner pour gérer les écouteurs
        Spin.setAdapter(aa);


    }
    // le traitement à faire si un choix est fait par l’utilisateur


    public void onItemSelected (AdapterView<?> parent, View v, int position, long id)
    {
        Selection.setText(item[position]);
    }

    // le traitement à faire si aucun choix n’est fait
    public void onNothingSelected(AdapterView<?> parent)
    {
        Selection.setText("");
    }


}
