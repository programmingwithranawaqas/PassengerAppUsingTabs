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


public class BusPassengerFragment extends Fragment {

    RecyclerView rvBus;
    LinearLayoutManager manager;
    public static MyPlanePassengerAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBus = view.findViewById(R.id.rvBus);
        manager = new LinearLayoutManager(getContext());



        rvBus.setHasFixedSize(true);
        rvBus.setLayoutManager(manager);

    }

    @Override
    public void onResume() {
        super.onResume();
        ArrayList<Passenger> busPassengers = new ArrayList<>();

        for(Passenger p:MyDataLists.passengers)
        {
            if(p.getPreference().equalsIgnoreCase("bus"))
            {
                busPassengers.add(p);
            }
        }

        adapter = new MyPlanePassengerAdapter(getContext(), busPassengers);
        rvBus.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bus_passenger, container, false);
    }
}