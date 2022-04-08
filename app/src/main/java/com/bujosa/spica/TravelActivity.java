package com.bujosa.spica;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bujosa.spica.adapter.TravelAdapter;
import com.bujosa.spica.entity.Travel;

public class TravelActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.available_travels);
        recyclerView=findViewById(R.id.listRecyclerView);
        recyclerView.setAdapter(new TravelAdapter(Travel.generateTravels()));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }
}
