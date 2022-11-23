package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnLogin = findViewById(R.id.btnLogin);
        EditText editTextNom = findViewById(R.id.editLoginNom);
        EditText editTextPass = findViewById(R.id.editLoginPass);
        TextView erreur = findViewById(R.id.textLoginErreur);
        btnLogin.setOnClickListener(view -> {
            String nom = editTextNom.getText().toString();
            String pass = editTextPass.getText().toString();
            if(nom.isEmpty() || pass.isEmpty()){
                erreur.setVisibility(View.VISIBLE);
            }
            else{
                Clients client = new Clients(nom);
               // Intent intent = new Intent
            }

        });
    }
}