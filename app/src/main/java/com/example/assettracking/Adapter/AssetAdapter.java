package com.example.assettracking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assettracking.Asset.Assets;
import com.example.assettracking.R;

import java.util.ArrayList;

public class AssetAdapter extends RecyclerView.Adapter<AssetAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Assets> assetsArrayList;

    public AssetAdapter(Context myContext, ArrayList<Assets> myAssets){
        context = myContext;
        assetsArrayList=myAssets;
    }

    @NonNull
    @Override
    public AssetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.gethistorydataforview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AssetAdapter.ViewHolder holder, int position) {
        holder.tvname.setText(assetsArrayList.get(position).getName());
        holder.tvlocation.setText(assetsArrayList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return assetsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvname, tvlocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvHistory);
            tvlocation = (TextView) itemView.findViewById(R.id.tvCheckins);

        }
    }
}
