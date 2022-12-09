package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pfi.databinding.ActivityDetailsBinding;

import java.io.Serializable;

public class details extends AppCompatActivity implements Serializable {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        binding = DataBindingUtil.setContentView(details.this, R.layout.activity_details);

        Produit produit = (Produit) getIntent().getSerializableExtra("produit");
        Clients client = (Clients) getIntent().getSerializableExtra("client");

        binding.img.setImageResource(produit.getImage());
        binding.txtViewNom.setText(produit.getNom());
        binding.txtViewPrix.setText(produit.getPrix());
        binding.txtViewCoeurs.setText(produit.getCoeurs());
        binding.txtViewDescription.setText(produit.getDescription());


        binding.btnRetour.setOnClickListener(view ->{
            Intent intent = new Intent(details.this, Produits.class);
            intent.putExtra("client",client);
            startActivity(intent);
        });
        binding.btnAddCart.setOnClickListener(view ->{
            client.addProduit(produit);
            MediaPlayer.create(this,
                    R.raw.son_ajout_panier).start();
        });
    }
}