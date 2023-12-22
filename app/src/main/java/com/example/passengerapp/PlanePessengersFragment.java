package com.example.passengerapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class PlanePessengersFragment extends Fragment {

    RecyclerView rvPlane;
    LinearLayoutManager manager;
    public static MyPlanePassengerAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPlane = view.findViewById(R.id.rvPlanes);
        manager = new LinearLayoutManager(getContext());




        //adapter = new MyPlanePassengerAdapter(getContext(), planePassengers);
        rvPlane.setHasFixedSize(true);
        rvPlane.setLayoutManager(manager);
        //rvPlane.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ArrayList<Passenger> planePassengers = new ArrayList<>();

        for(Passenger p:MyDataLists.passengers)
        {
            if(p.getPreference().equalsIgnoreCase("plane"))
            {
                planePassengers.add(p);
            }
        }
        adapter = new MyPlanePassengerAdapter(getContext(), planePassengers);
        rvPlane.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plane_pessengers, container, false);
    }
}