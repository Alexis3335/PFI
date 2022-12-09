package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class PageFin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_fin);

        MediaPlayer sonPayer = MediaPlayer.create(this,R.raw.son_payer_panier);
        sonPayer.start();
    }
}