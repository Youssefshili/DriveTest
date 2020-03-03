package com.example.josef.contact_list;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;

 import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Contact_list extends ActionBarActivity implements ContactAdapter.ContactAdapterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        //Récupération de la liste des contacts
        ArrayList<Contact> listP = Contact.Initialiser();
        //Création et initialisation de l'Adaptateur pour les contacts
        ContactAdapter adapter = new ContactAdapter(this, listP);
        adapter.addListener( (ContactAdapter.ContactAdapterListener) this );
        //Récupération du composant ListView
                   ListView list = (ListView)findViewById(R.id.listView1);
        //Initialisation de la liste avec les données
        list.setAdapter(adapter);


    }

    public void onClickNom(Contact item, int position) {
        // création d’une boite de dialogue dont le contexte d’affiche est l’activité
        // en cours pointée par this

        Builder builder = new AlertDialog.Builder(this);

        // écrire le titre de de la boite de dialogue
                  builder.setTitle("Information sur le contact");

        // affichage du téléphone du contact sélectionné par l’utilisateur

        builder.setMessage("Le telephone est : " + item.telephone);

        // creation d’un bouton ok dans la boite de dialogue
         builder.setPositiveButton("OK", null);

        // affichage de la boite de dialgue
          builder.show();      }


}



