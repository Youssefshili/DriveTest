package com.example.josef.autocomplete_demo;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
 import android.widget.TextView;
import android.widget.ArrayAdapter;

public class MainActivity extends ActionBarActivity implements TextWatcher {
    //déclaration des variables de la classe
     TextView Selection;
     AutoCompleteTextView edit;

    String[] items={"Tunisie","Turqui","Tailand","France","Felande","Algerie","Arabie Saoudite", "Eriteria","Etat Unis","Maroc","Mauritanie"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Selection = (TextView) findViewById(R.id.textView1);
        edit = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        //affectation des écouteurs de Texte qui s’activent lors d’une saisie ou
        // sélection d’un texte

        edit.addTextChangedListener(this);
        // création et affectation d’un adaptateur du type ArrayAdapter dont les
        // éléments de son tableau sont des chaines de caractères et qui seront
        // affectées aux différentes lignes de l’AutoCompleteTextView a partir de la
        // variable item
                  edit.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,items));
    }
    // Le traitement à faire si un texte est saisi ou sélectionné à partir de la
    // liste proposée

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
        {     Selection.setText(edit.getText());
        }
    public void beforeTextChanged(CharSequence s, int start, int count, int after)
    {
        //impose par l'interface mais non utilise
          }
        public void afterTextChanged (Editable s)
        {
            // impose par l'interface mais non utilisee
                }

    }
