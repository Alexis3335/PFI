package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
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
            startActivity(intent);
        });
        binding.btnAddCart.setOnClickListener(view ->{
            client.addProduit(produit);
            //String msg = getString(R.string.msg_added_to_cart);
            //Context context = this.getApplicationContext();
            //int duration = Toast.LENGTH_SHORT;
            //Toast toast = Toast.makeText(context, msg, duration);
            //toast.show();
        });

    }
}