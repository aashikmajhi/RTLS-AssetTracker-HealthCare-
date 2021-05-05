package com.example.assettracking.Dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assettracking.R;
import com.example.assettracking.View.VIewAssetHistory;

public class Dashboard extends AppCompatActivity {

    private androidx.cardview.widget.CardView Stethoscope, Sphygmomanometer, Clamps, Laryngoscope, Laparoscopic, Pulse, Retractors, Defibrillator, Headlamp, Staplers, Scissors, Energy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Stethoscope = findViewById(R.id.Stethoscope);
        Sphygmomanometer = findViewById(R.id.Sphygmomanometer);
        Clamps = findViewById(R.id.Clamps);
        Laryngoscope = findViewById(R.id.Laryngoscope);
        Laparoscopic = findViewById(R.id.Laparoscopic);
        Pulse = findViewById(R.id.Pulse);
        Retractors = findViewById(R.id.Retractors);
        Defibrillator = findViewById(R.id.Defibrillator);
        Headlamp = findViewById(R.id.Headlamp);
        Staplers = findViewById(R.id.Staplers);
        Scissors = findViewById(R.id.Scissors);
        Energy = findViewById(R.id.Energy);


        Stethoscope.setOnClickListener(view -> {
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Sphygmomanometer.setOnClickListener(view -> {
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Clamps.setOnClickListener(view -> {
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Laryngoscope.setOnClickListener(view -> {
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Laparoscopic.setOnClickListener(view -> {
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Pulse.setOnClickListener(v->{
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Retractors.setOnClickListener(v->{
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Defibrillator.setOnClickListener(v->{
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Headlamp.setOnClickListener(v->{
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Staplers.setOnClickListener(v->{
            startActivity(new Intent(this, VIewAssetHistory.class));
        });


        Scissors.setOnClickListener(view -> {
            startActivity(new Intent(this, VIewAssetHistory.class));
        });

        Energy.setOnClickListener(view -> {
            startActivity(new Intent(this, VIewAssetHistory.class));
        });

    }
}