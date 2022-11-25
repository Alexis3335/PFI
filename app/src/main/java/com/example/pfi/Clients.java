package com.example.pfi;

import java.io.Serializable;

/**
 * Représente un client
 * Un client a un nom et le prix de son panier (défaut = 0)
 * @author Alexis Perreault
 */
public class Clients implements Serializable {
    private String nom;
    private double prixPanier;
    private static Clients instance;

    private Clients(String nom) {
        this.nom = nom;
        prixPanier = 0;
    }

    /**
     * Retourne l'instance courante de client, ou la crée si elle n'existe âs
     * @param nom Le nom du client (seulement nécéssaire si on crée un instance)
     * @return L'instance de client
     */
    synchronized public static Clients getInstance(String nom){
        return instance == null ? new Clients(nom) : instance;
    }

    /**
     * Supprime l'instance courante de client
     */
    synchronized public static void deleteInstance(){
        instance = null;
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
