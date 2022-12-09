package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageFin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_fin);

        MediaPlayer sonPayer = MediaPlayer.create(this,R.raw.son_payer_panier);
        sonPayer.start();

        Button btnRetour = findViewById(R.id.btnRetourFin);
        Clients client = (Clients)getIntent().getSerializableExtra("client");

        btnRetour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                client.emptyProduits();
                Intent intent = new Intent(PageFin.this, Produits.class);
                intent.putExtra("client", client);
                startActivity(intent);
            }
        });
    }
}