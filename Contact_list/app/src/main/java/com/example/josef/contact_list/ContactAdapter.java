
package com.example.josef.contact_list;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {
    // Une liste de contact
    private List<Contact> mListP;
    //Le contexte dans lequel est présent notre adapter
    private Context mContext;
    // Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;
    private OnClickListener ClickListener;

    // le constructeur
    public ContactAdapter(Context context, List<Contact> aListP) {
        mContext = context;
        mListP = aListP;
        //Le LayoutInflater permet de parser un layout XML et de le transcoder en IHM Android.
        mInflater = LayoutInflater.from(mContext);
    }
    //Pour respecter l'interface BaseAdapter, il nous faut spécifier la méthode "getcount()".


    public int getCount() {

        return mListP.size();
    }
    //retirer un élément de la liste

    public Object getItem(int position) {
        return mListP.get(position);
    }

    // fournir l’identifiant d'un élément de la liste à partir de sa position
    public long getItemId(int position) {

        return position;
    }
    // Maintenant il faut surcharger la méthode pour renvoyer une "View"
    // en fonction d'une position donnée.
    // le View pour notre cas est un élément de la listeView et qui correspond à un contact
     public View getView(int position, View convertView, ViewGroup parent)  {
         LinearLayout layoutItem;
         //(1) : Réutilisation des layouts
           if (convertView == null)      {
               //Initialisation de notre item à partir du layout XML layout.xml"
               layoutItem = (LinearLayout) mInflater.inflate(R.layout.activity_contact_list, parent, false);
           }
           else  {
               layoutItem = (LinearLayout) convertView;
           }


    //(2) : Récupération des TextView de notre layout
     TextView tv_Nom = (TextView)layoutItem.findViewById(R.id.Nom);
    TextView tv_Prenom = (TextView)layoutItem.findViewById(R.id.Prenom);
    //(3) : Renseignement des valeurs
    tv_Nom.setText(mListP.get(position).nom);
    tv_Prenom.setText(mListP.get(position).prenom);
         // (4) : On mémorise la position de la "Contact" dans le composant textview
         tv_Nom.setTag(position);
         // On ajoute un listener
         tv_Nom.setOnClickListener( ClickListener = new OnClickListener(){
             @Override
         public void onClick(View v) {
             //Lorsque l'on clique sur le nom, on récupère la position de la "Personne"
             Integer position = (Integer) v.getTag();
             sendListener(mListP.get(position), position);

         }
         });
    //On retourne l'item créé.
     return layoutItem ;
}
    //Interface pour écouter les évènements sur le nom d'un contact
    public interface ContactAdapterListener {

// la fonction qui sera implémentée par toute classe qui utilise l’interface

        public void onClickNom(Contact item, int position);

    }
//création d’une liste d’écouteurs

    private ArrayList<ContactAdapterListener> mListListener = new ArrayList<ContactAdapterListener>();

    // ajouter un listener sur notre liste de contacte
    public void addListener(ContactAdapterListener aListener) {

        mListListener.add(aListener);
    }

    //permet de activer tous les listeners de notre liste
    private void sendListener(Contact item, int position) {
        for (int i = mListListener.size() - 1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }


    }}