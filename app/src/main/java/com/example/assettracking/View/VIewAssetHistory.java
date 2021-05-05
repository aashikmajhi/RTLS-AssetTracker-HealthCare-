package com.example.assettracking.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assettracking.Adapter.AssetAdapter;
import com.example.assettracking.Asset.Assets;
import com.example.assettracking.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VIewAssetHistory extends AppCompatActivity {
    private RecyclerView recyclerviewforhistory;
    private DatabaseReference ref;
    String k;
    private AssetAdapter myAssedAdapter;
    private ArrayList<Assets> myAssets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_asset_history);

        recyclerviewforhistory = findViewById(R.id.recyclerforhistory);
        ref = FirebaseDatabase.getInstance().getReference().child("Sphygmomanometer");


        recyclerviewforhistory.setLayoutManager(new LinearLayoutManager(this));
        myAssets=new ArrayList<Assets>();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> arrayList=new ArrayList<>();
                for (DataSnapshot ds : snapshot.getChildren()) {
//                    Log.d("TAGGER",  ds.toString());
                    arrayList.add(ds.getValue().toString());
                    Log.d("Arraylis",arrayList.toString());
                }
                myAssedAdapter=new AssetAdapter(VIewAssetHistory.this,arrayList);
                recyclerviewforhistory.setAdapter(myAssedAdapter);
//
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(VIewAssetHistory.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}