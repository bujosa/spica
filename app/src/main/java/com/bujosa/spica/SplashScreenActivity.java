package com.bujosa.spica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.splashScreenTheme);
        SystemClock.sleep(1000);
        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        finish();
    }
}