package com.example.pfi;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptateur extends RecyclerView.Adapter<Adaptateur.MyViewHolder> {

    Context context;
    ArrayList<Produit> produits;

    public Adaptateur(Context context,ArrayList<Produit> produits){
        this.context = context;
        this.produits = produits;
    }

    @NonNull
    @Override
    public Adaptateur.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(context);
        View itemView = inflator.inflate(R.layout.produit_ligne,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptateur.MyViewHolder holder, int position) {
        holder.txtNom.setText(produits.get(position).getNom());
        holder.image.setBackgroundResource(produits.get(position).getImage());
        holder.produit = produits.get(position);
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNom;
        ImageView image;
        Produit produit;
        ConstraintLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNom = itemView.findViewById(R.id.nomProduitRecycler);
            image = itemView.findViewById(R.id.imageProduitRecycler);
            layout = itemView.findViewById(R.id.contraintLayoutProduitLigne);

            layout.setOnClickListener(view -> {
                Toast t = Toast.makeText(context,produit.getNom(), Toast.LENGTH_LONG);
                t.show();
            });

        }
    }
}
