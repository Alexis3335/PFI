package com.example.pfi;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Représente un client
 * Un client a un nom et le prix de son panier (défaut = 0)
 * @author Alexis Perreault
 */
public class Clients implements Serializable {
    private String nom;
    private int prixPanier;
    private static Clients instance;
    private ArrayList<Produit> produits = new ArrayList<>();

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }

    public void addProduit(Produit produit){
        this.produits.add(produit);
    }

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

    public int getPrixPanier() {
        return prixPanier;
    }

    public void setPrixPanier(int prixPanier) {
        this.prixPanier = prixPanier;
    }
}
