package com.example.chaima.myapplication;


public class Prisoner {

    private int matricule;
    private String nom;
    private int photoID;
    private String adresse;
    private String notes;

    public Prisoner(int matricule, String nom, int photoID, String adresse, String notes) {
        this.matricule = matricule;
        this.nom = nom;
        this.photoID = photoID;
        this.adresse = adresse;
        this.notes = notes;
    }
    public Prisoner(int matricule,String notes) {
        this.matricule = matricule;
        this.notes = notes;
    }
    public Prisoner() {
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public int getPhotoID() {
        return photoID;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNotes() {
        return notes;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
