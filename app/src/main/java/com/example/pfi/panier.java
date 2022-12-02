package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class panier extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        Intent intent = getIntent();
        Clients client = (Clients)intent.getSerializableExtra("client");
        ArrayList<Produit> panier = client.getProduits();

        Button retour = (Button) findViewById(R.id.btnRetourPanier);
        RecyclerView recycler = findViewById(R.id.recyclerPanier);
        boolean estPanier = true;

        Adaptateur adaptateur = new Adaptateur(getApplicationContext(),panier, estPanier);
        adaptateur.client = client;
        recycler.setAdapter(adaptateur);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setHasFixedSize(true);


    }
}