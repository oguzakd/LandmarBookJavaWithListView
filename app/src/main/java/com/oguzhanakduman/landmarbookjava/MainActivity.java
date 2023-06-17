package com.oguzhanakduman.landmarbookjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.oguzhanakduman.landmarbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        // Data (Daha sonrasında bu veriler veritabanından gelecektir.)
        Landmark pisa = new Landmark("Pisa","İtalya", R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel", "Fransa", R.drawable.eiffel);
        Landmark collesium = new Landmark("Collesium", "İtalya", R.drawable.collesium);
        Landmark londonBridge = new Landmark("London Bridge", "İngiltere", R.drawable.londonbridge);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(collesium);
        landmarkArrayList.add(londonBridge);

        // Adapter - ListView - Mapping
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));

        binding.listView.setAdapter(arrayAdapter);

        // Liste elemanlarına tıklanması durumunun kontrolü
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(i));
                startActivity(intent);

            }
        });

    }
}