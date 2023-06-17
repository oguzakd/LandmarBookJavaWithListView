package com.oguzhanakduman.landmarbookjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.oguzhanakduman.landmarbookjava.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        // Casting
        Landmark landmark = (Landmark) intent.getSerializableExtra("landmark");

        binding.nameTextView.setText(landmark.name);
        binding.countryTextView2.setText(landmark.country);
        binding.imageView.setImageResource(landmark.image);
    }
}