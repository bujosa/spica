package com.bujosa.spica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bujosa.spica.entity.Travel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TravelDetailActivity extends AppCompatActivity {

    TextView title, secondTitle, description, location, price, startDate, endDate;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_detail);

        Travel travel = (Travel) getIntent().getSerializableExtra("Travel");

        title = findViewById(R.id.detailTitleTextView);
        secondTitle = findViewById(R.id.itemTextView);
        description = findViewById(R.id.detailDescriptionTextView);
        price = findViewById(R.id.detailPriceTextView);
        imageView = findViewById(R.id.detailImageView);
        location = findViewById(R.id.detailLocationTextView);
        startDate = findViewById(R.id.detailStartDateTextView);
        endDate = findViewById(R.id.detailEndDateTextView);

        String priceResult = "" + travel.getPrice();
        Picasso.get()
                .load(travel.getImage())
                .placeholder(android.R.drawable.ic_dialog_map)
                .error(android.R.drawable.ic_dialog_alert)
                .into(imageView);

        title.setText(travel.getTitle());
        secondTitle.setText(travel.getTitle());
        description.setText(travel.getDescription());
        price.setText(priceResult);
        location.setText(travel.getPlace());
        startDate.setText(travel.getStartDate());
        endDate.setText(travel.getEndDate());

    }
}