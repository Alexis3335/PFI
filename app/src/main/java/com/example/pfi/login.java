package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnLogin = findViewById(R.id.btnLogin);
        EditText editTextNom = findViewById(R.id.editLoginNom);
        EditText editTextPass = findViewById(R.id.editLoginPass);
        btnLogin.setOnClickListener(view -> {

        });
    }
}