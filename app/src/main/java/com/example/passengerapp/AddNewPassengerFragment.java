package com.example.passengerapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class AddNewPassengerFragment extends Fragment {

    TextInputEditText etName, etPref, etCnic, etMobile;
    Button btnAddNewPassenger, btnClear;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName = view.findViewById(R.id.etName);
        etPref = view.findViewById(R.id.etPref);
        etCnic = view.findViewById(R.id.etCnic);
        etMobile = view.findViewById(R.id.etMobile);
        btnClear = view.findViewById(R.id.btnClear);
        btnAddNewPassenger = view.findViewById(R.id.btnAddNewPassenger);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFields();
            }
        });

        btnAddNewPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String pref = etPref.getText().toString().trim();
                String cnic = etCnic.getText().toString().trim();
                String mobile = etMobile.getText().toString().trim();
                if(!name.isEmpty() && !pref.isEmpty() && !cnic.isEmpty() && !mobile.isEmpty())
                {
                    MyDataLists.passengers.add(new Passenger(name, pref, cnic,mobile));
                    //Toast.makeText(getContext(), ""+MyDataLists.passengers.size(), Toast.LENGTH_SHORT).show();
                    if(pref.equalsIgnoreCase("plane"))
                    {
                        PlanePessengersFragment.adapter.notifyDataSetChanged();
                    }
                    else if(pref.equalsIgnoreCase("bus"))
                    {
                        BusPassengerFragment.adapter.notifyDataSetChanged();
                    }
                    clearFields();
                    Toast.makeText(getContext(), "Passenger Added", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if(name.isEmpty())
                    {
                        etName.setError("Name must be entered.");
                    }
                    if(pref.isEmpty())
                    {
                        etPref.setError("Pref must be entered.");
                    }
                    if(cnic.isEmpty())
                    {
                        etCnic.setError("Cnic must be entered.");
                    }
                    if(mobile.isEmpty())
                    {
                        etMobile.setError("Mobile must be entered.");
                    }

                }
            }
        });


    }

    private void clearFields()
    {
        etName.setText("");
        etMobile.setText("");
        etCnic.setText("");
        etPref.setText("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_passenger, container, false);
    }
}