package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Produits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);

        ArrayList<Produit> arrProduits = new ArrayList<Produit>();
        RecyclerView recycler = findViewById(R.id.recyclerProduits);
        Button btnAllerPanier = findViewById(R.id.btnAllerPanier);
        Clients client = (Clients) getIntent().getSerializableExtra("client");

        btnAllerPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Produits.this,panier.class);
                intent.putExtra("client",client);
                startActivity(intent);
            }
        });

        remplirProduits(arrProduits);

        Adaptateur adaptateur = new Adaptateur(getApplicationContext(),arrProduits);
        adaptateur.client = client;
        recycler.setAdapter(adaptateur);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setHasFixedSize(true);


    }

    public void remplirProduits(ArrayList<Produit> produits){
        produits.add(new Produit(getString(R.string.carrot_stew_name),getString(R.string.carrot_stew_description),
        R.drawable.carrot_stew,getString(R.string.carrot_stew_price),getString(R.string.carrot_stew_hearts)));

        produits.add(new Produit(getString(R.string.egg_pudding_name),getString(R.string.egg_pudding_description),
                R.drawable.egg_pudding,getString(R.string.egg_pudding_price),getString(R.string.egg_pudding_hearts)));

        produits.add(new Produit(getString(R.string.egg_tart_name),getString(R.string.egg_tart_description),
                R.drawable.egg_tart,getString(R.string.egg_tart_price),getString(R.string.egg_tart_hearts)));

        produits.add(new Produit(getString(R.string.creamy_heart_soup_name),getString(R.string.creamy_heart_soup_description),
                R.drawable.creamy_heart_soup,getString(R.string.creamy_heart_soup_price),
                getString(R.string.creamy_heart_soup_hearts)));

        produits.add(new Produit(getString(R.string.creamy_meat_soup_name),getString(R.string.creamy_meat_soup_description),
                R.drawable.creamy_meat_soup,getString(R.string.creamy_meat_soup_price),
                getString(R.string.creamy_meat_soup_hearts)));

        produits.add(new Produit(getString(R.string.gourmet_poultry_name),getString(R.string.gourmet_poultry_description),
                R.drawable.gourmet_poultry,getString(R.string.gourmet_poultry_price),getString(R.string.gourmet_poultry_hearts)));

        produits.add(new Produit(getString(R.string.hot_pot_name),getString(R.string.hot_pot_description),
                R.drawable.hot_pot,getString(R.string.hot_pot_price),getString(R.string.hot_pot_hearts)));

        produits.add(new Produit(getString(R.string.omelet_name),getString(R.string.omelet_description),
                R.drawable.omelet,getString(R.string.omelet_price),getString(R.string.omelet_hearts)));

        produits.add(new Produit(getString(R.string.pepper_steak_name),getString(R.string.pepper_steak_description),
                R.drawable.pepper_steak,getString(R.string.pepper_steak_price),getString(R.string.pepper_steak_hearts)));

        produits.add(new Produit(getString(R.string.pumpkin_stew_name),getString(R.string.pumpkin_stew_description),
                R.drawable.pumpkin_stew,getString(R.string.pumpkin_stew_price),getString(R.string.pumpkin_stew_hearts)));

        produits.add(new Produit(getString(R.string.salt_grilled_crab_name),getString(R.string.salt_grilled_crab_description),
                R.drawable.salt_grilled_crab,getString(R.string.salt_grilled_crab_price),
                getString(R.string.salt_grilled_crab_hearts)));

        produits.add(new Produit(getString(R.string.seafood_rice_balls_name),getString(R.string.seafood_rice_balls_description),
                R.drawable.seafood_rice_balls,getString(R.string.seafood_rice_balls_price),
                getString(R.string.seafood_rice_balls_hearts)));

        produits.add(new Produit(getString(R.string.vegetable_risotto_name),getString(R.string.vegetable_risotto_description),
                R.drawable.vegetable_risotto,getString(R.string.vegetable_risotto_price),
                getString(R.string.vegetable_risotto_hearts)));

        produits.add(new Produit(getString(R.string.meat_pie_name),getString(R.string.meat_pie_description),
                R.drawable.meat_pie,getString(R.string.meat_pie_price),getString(R.string.meat_pie_hearts)));

        produits.add(new Produit(getString(R.string.steamed_fish_name),getString(R.string.steamed_fish_description),
                R.drawable.steamed_fish,getString(R.string.steamed_fish_price),getString(R.string.steamed_fish_hearts)));
    }
}