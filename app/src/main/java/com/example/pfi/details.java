package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import com.example.pfi.databinding.ActivityDetailsBinding;

public class details extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //getIntent()

        binding = DataBindingUtil.setContentView(details.this, R.layout.activity_details);
        //binding.
    }
}