package com.example.assettracking.View;

import android.os.Bundle;
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
    private AssetAdapter myAssedAdapter;
    private ArrayList<Assets> myAssets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_asset_history);

        recyclerviewforhistory = findViewById(R.id.recyclerforhistory);
        ref = FirebaseDatabase.getInstance().getReference().child("FirebaseIOT");
        recyclerviewforhistory.setLayoutManager(new LinearLayoutManager(this));
        myAssets=new ArrayList<Assets>();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    dataSnapshot.getValue(Assets.class);
                    Assets assets = dataSnapshot.getValue(Assets.class);
                    myAssets.add(assets);
                }

                myAssedAdapter=new AssetAdapter(VIewAssetHistory.this,myAssets);
                recyclerviewforhistory.setAdapter(myAssedAdapter);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(VIewAssetHistory.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}