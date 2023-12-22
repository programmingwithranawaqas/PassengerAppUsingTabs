package com.example.passengerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPlanePassengerAdapter extends RecyclerView.Adapter<MyPlanePassengerAdapter.ViewHolder>{

    ArrayList<Passenger> passengerArrayList;

    public MyPlanePassengerAdapter(Context context, ArrayList<Passenger> passengers)
    {
        passengerArrayList = passengers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.single_passenger_list_item_design, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(passengerArrayList.get(position));
        holder.tvName.setText(passengerArrayList.get(position).getName());
        holder.tvCnic.setText(passengerArrayList.get(position).getCnic());

        if(passengerArrayList.get(position).getPreference().equalsIgnoreCase("plane"))
        {
            holder.ivPref.setImageResource(R.drawable.plane);
        }
        else if(passengerArrayList.get(position).getPreference().equalsIgnoreCase("bus"))
        {
            holder.ivPref.setImageResource(R.drawable.bus);
        }

    }

    @Override
    public int getItemCount() {
        return passengerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName, tvCnic;
        ImageView ivPref, ivCall;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.splidTvName);
            tvCnic = itemView.findViewById(R.id.splidTvCnic);
            ivPref = itemView.findViewById(R.id.splidIvPref);
            ivCall = itemView.findViewById(R.id.splidIvCall);




        }
    }
}
