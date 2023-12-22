package com.example.passengerapp;

import android.app.Application;

import java.util.ArrayList;

public class MyDataLists extends Application {
    public static ArrayList<Passenger> passengers;

    @Override
    public void onCreate() {
        super.onCreate();
        passengers = new ArrayList<>();

        passengers.add(new Passenger("Ali","bus","352120212","03122"));
        passengers.add(new Passenger("Ami","plane","352120212","03122"));
        passengers.add(new Passenger("Abu","plane","352120212","03122"));
        passengers.add(new Passenger("Raza","bus","352120212","03122"));

    }
}
