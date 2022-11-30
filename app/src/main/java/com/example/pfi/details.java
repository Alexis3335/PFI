package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
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
        Clients c = (Clients) getIntent().getSerializableExtra("client");
        System.out.println(c.getNom());

        binding.img.setImageResource(produit.getImage());
        binding.txtViewNom.setText(produit.getNom());
        binding.txtViewPrix.setText(produit.getPrix());
        binding.txtViewCoeurs.setText(produit.getCoeurs());
        binding.txtViewDescription.setText(produit.getDescription());

        binding.btnRetour.setOnClickListener(view ->{
            Intent intent = new Intent(details.this, Produits.class);
            startActivity(intent);
        });

    }
}