package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageFin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_fin);

        Button btnRetour = findViewById(R.id.btnRetourFin);
        Clients client = (Clients)getIntent().getSerializableExtra("client");

        btnRetour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                client.emptyProduits();
                Intent intent = new Intent(PageFin.this, login.class);
                intent.putExtra("client", client);
                startActivity(intent);
            }
        });
        btnRetour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
                System.exit(0);
            }
        });
    }
}