package com.bujosa.spica;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bujosa.spica.adapter.TravelAdapter;
import com.bujosa.spica.entity.Travel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TravelActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.available_travels);

        recyclerView=findViewById(R.id.listRecyclerView);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("travels", null);

        Type type = new TypeToken<ArrayList<Travel>>() {}.getType();
        List<Travel> travels = gson.fromJson(json, type);

        recyclerView.setAdapter(new TravelAdapter(travels, this, true));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }
}
