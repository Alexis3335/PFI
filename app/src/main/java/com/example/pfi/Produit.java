package com.example.pfi;

import android.graphics.drawable.Drawable;

public class Produit {
    private String nom;
    private String description;
    private int image;
    private double prix;

    public Produit(String nom,String description,int image,double prix) {
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.prix = prix;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
