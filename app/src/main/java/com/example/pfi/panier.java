package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
        Button payer = (Button) findViewById(R.id.btnPayerPanier);
        RecyclerView recycler = findViewById(R.id.recyclerPanier);
        boolean estPanier = true;


        Adaptateur adaptateur = new Adaptateur(this,getApplicationContext(),
                panier, estPanier);
        TextView nomprenom = findViewById(R.id.prenomnom);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                char[] nom = client.getNom().toCharArray();
                while(true){
                    for(char c : nom){
                        String curr = nomprenom.getText().toString() + c;
                        nomprenom.setText(curr);

                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(curr.equals(client.getNom()))
                            nomprenom.setText("");
                    }
                }
            }
        });

        th.start();

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(panier.this,Produits.class);
                intent.putExtra("client",client);
                startActivity(intent);
            }
        });
        payer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client.emptyProduits();
                Intent intent = new Intent(panier.this,PageFin.class);
                intent.putExtra("client",client);
                startActivity(intent);
            }
        });
        adaptateur.client = client;
        recycler.setAdapter(adaptateur);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setHasFixedSize(true);

    }
}