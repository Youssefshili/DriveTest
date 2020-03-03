package com.example.josef.contact_list;
import java.util.ArrayList;
/**
 * Created by josef on 07/01/2020.
 */

public class Contact {
    // déclaration des attributs de la classe Contact
            public String nom;
     public String prenom;
    public String telephone;
    // le constructeur de la classe
     public Contact(String aNom, String aPrenom, String aTelephone)
     {
    nom = aNom;
      prenom = aPrenom;
     telephone = aTelephone;
      }
    // création de l'adaptateur qui initialise et permet de gérer une liste
    // de contact
        public static ArrayList<Contact> Initialiser ()
        {
            ArrayList<Contact> listContact = new ArrayList<Contact>();

    Contact MonContact = new Contact("Dupont", "Thierry", "0124524521");
    listContact.add(MonContact);
    MonContact = new Contact("Tournesol", "Philippe", "054878569");
    listContact.add(MonContact);
    MonContact = new Contact("Martin", "Pecheur", "048578544");
    listContact.add(MonContact);
    MonContact = new Contact("Castafiore", "Helene", "08985785");
    listContact.add(MonContact);
 MonContact = new Contact("Dalton", "Joe", "0356898547");
    listContact.add(MonContact);
    MonContact = new Contact("Dalton", "Ma", "9874587444");
    listContact.add(MonContact);
    MonContact = new Contact("Obelix", "Gros", "025445836");
    listContact.add(MonContact);
    return listContact;

}
        }
