package com.example.pfi;

/**
 * Représente un client
 * Un client a un nom et le prix de son panier (défaut = 0)
 * @author Alexis Perreault
 */
public class Clients {
    private String nom;
    private double prixPanier;

    public Clients(String nom) {
        this.nom = nom;
        prixPanier = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixPanier() {
        return prixPanier;
    }

    public void setPrixPanier(double prixPanier) {
        this.prixPanier = prixPanier;
    }
}
