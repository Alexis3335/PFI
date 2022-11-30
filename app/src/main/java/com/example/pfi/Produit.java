package com.example.pfi;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Produit implements Serializable {
    private String nom;
    private String description;
    private int image;
    private String prix;
    private String coeurs;

    public Produit(String nom,String description,int image,String prix,String coeurs) {
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.prix = prix.substring(0, prix.length() - 2);
        this.coeurs = coeurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getCoeurs() {
        return coeurs;
    }

    public void setCoeurs(String coeurs) { this.coeurs = coeurs;
    }
}
