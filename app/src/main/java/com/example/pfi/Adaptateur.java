package com.example.pfi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptateur extends RecyclerView.Adapter<Adaptateur.MyViewHolder> {

    Context context;
    ArrayList<Produit> produits;
    Clients client;
    Activity activity;
    boolean estPanier;

    public Adaptateur(Activity activity,Context context,
                      ArrayList<Produit> produits, boolean estPanier){
        this.context = context;
        this.produits = produits;
        this.estPanier = estPanier;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Adaptateur.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(context);
        View itemView;
        if(!estPanier)
            itemView = inflator.inflate(R.layout.produit_ligne,parent,false);
        else
            itemView = inflator.inflate(R.layout.produit_panier_ligne,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptateur.MyViewHolder holder, int position) {
        holder.txtNom.setText(produits.get(position).getNom());
        holder.image.setBackgroundResource(produits.get(position).getImage());
        holder.produit = produits.get(position);
        holder.client = client;

        if(estPanier)
            holder.prix.setText(produits.get(position).getPrix());
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNom;
        ImageView image;
        Produit produit;
        Clients client;
        TextView prix;

        ConstraintLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            if (!estPanier){
                txtNom = itemView.findViewById(R.id.nomProduitRecycler);
                image = itemView.findViewById(R.id.imageProduitRecycler);
                layout = itemView.findViewById(R.id.contraintLayoutProduitLigne);
                layout.setOnClickListener(view -> {
                    Intent intent = new Intent(view.getContext(), details.class);
                    intent.putExtra("produit", produit);
                    intent.putExtra("client", client);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                });
            }
            else {
                txtNom = itemView.findViewById(R.id.nomProduit);
                image = itemView.findViewById(R.id.imageProduit);
                prix = itemView.findViewById(R.id.prixProduit);
                layout = itemView.findViewById(R.id.constraintLayoutProduitPanierLigne);
            }
        }
    }
}
